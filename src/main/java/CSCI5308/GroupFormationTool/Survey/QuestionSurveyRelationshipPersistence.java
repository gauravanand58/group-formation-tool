package CSCI5308.GroupFormationTool.Survey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Questions.Question;

public class QuestionSurveyRelationshipPersistence implements IQuestionSurveyRelationshipPersistence{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Question> loadQUestionsByCourseId(long courseId) {
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadQuestionsForCourseID(?)");
			proc.setParameter(1, courseId);
			
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					Question question = new Question();
					question.setQuestionID(results.getInt(1));
					question.setQuestionTitle(results.getString(3));
					question.setQuestionType(results.getString(5));
					question.setQuestionText(results.getString(4));					
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadQuestionsForCourseID() throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questions;
	}

}
