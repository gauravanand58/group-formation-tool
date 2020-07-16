package CSCI5308.GroupFormationTool.Survey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class SurveyDB implements ISurveyPersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<IQuestion> loadQuestionsByCourseId(long courseId) {
		List<IQuestion> questions = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadQuestionsForCourseID(?)");
			proc.setParameter(1, courseId);

			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					IQuestion question = QuestionAbstractFactory.instance().makeQuestion();
					question.setQuestionID(results.getInt(1));
					question.setQuestionTitle(results.getString(3));
					question.setQuestionType(results.getString(5));
					question.setQuestionText(results.getString(4));
					question.setQuestionDateTime(results.getString(6));
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

	public List<IQuestion> getAvailableQuestions(long surveyId, long courseId, long instructorId) {
		List<IQuestion> questions = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spGetQuestionsAvailableForSurvey(?, ?, ?)");
			System.out.println(
					"surveyId is: " + surveyId + "courseId is: " + courseId + "instructorId is: " + instructorId);
			proc.setParameter(1, surveyId);
			proc.setParameter(2, courseId);
			proc.setParameter(3, instructorId);

			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					IQuestion question = QuestionAbstractFactory.instance().makeQuestion();
					question.setQuestionID(results.getInt(1));
					question.setInstructorID(instructorId);
					question.setQuestionTitle(results.getString(3));
					question.setQuestionType(results.getString(5));
					question.setQuestionText(results.getString(4));
					question.setQuestionDateTime(results.getString(6));
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			logger.error("spGetQuestionsAvailableForSurvey() throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questions;
	}

	public void addQuestionToSurvey(IQuestion question, long courseId) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spAddQuestionToSurvey(?, ?)");
			proc.setParameter(1, question.getQuestionID());
			proc.setParameter(2, courseId);
			proc.execute();
		} catch (SQLException e) {
			logger.error("spAddQuestionToSurvey(?, ?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.debug("Question added successfully to Survey");
	}

	public void loadSurveyByCourseID(ISurvey survey, long courseId) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spGetSurveyForCourseID(?)");
			proc.setParameter(1, courseId);
			ResultSet results = proc.executeWithResults();
			if (null != results && results.next()) {
				survey.setSurveyId(results.getInt(1));
				survey.setInstructorId(results.getLong(2));
				survey.setCourseId(results.getLong(3));
				survey.setPublished(results.getBoolean(4));
			}
		} catch (SQLException e) {
			logger.error("spGetSurveyForCourseID(?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}

	@Override
	public boolean publishSurvey(long surveyID) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spPublishSurveyByID(?)");
			proc.setParameter(1, surveyID);
			proc.execute();
		} catch (SQLException e) {
			logger.error("spPublishSurveyByID throws SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.debug("Successfully published survey with ID:" + surveyID);
		return true;
	}

}
