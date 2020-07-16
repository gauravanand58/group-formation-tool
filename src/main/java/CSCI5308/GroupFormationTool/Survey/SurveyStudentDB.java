package CSCI5308.GroupFormationTool.Survey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.IQuestionOption;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class SurveyStudentDB implements ISurveyStudentPersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<IQuestion> viewSurveyQuestions(long courseID) {
		CallStoredProcedure proc = null;
		List<IQuestion> surveyQuestions = new ArrayList<IQuestion>();
		List<IQuestionOption> tempQuestionOptionObj;
		IQuestion question;
		IQuestionOption questionOption;
		try {
			proc = new CallStoredProcedure("spcheckIfSurveyPublished(?)");
			proc.setParameter(1, courseID);
			ResultSet results = proc.executeWithResults();
			ResultSet resultOption;
			if (null != results) {

				while (results.next()) {
					question = QuestionAbstractFactory.instance().makeQuestion();
					question.setQuestionID(results.getInt(1));
					question.setQuestionText(results.getString(2));
					question.setQuestionType(results.getString(3));

					proc = new CallStoredProcedure("sploadallquestionoptions(?)");
					proc.setParameter(1, results.getInt(1));
					resultOption = proc.executeWithResults();
					if (null != resultOption) {
						tempQuestionOptionObj = new ArrayList<>();
						while (resultOption.next()) {
							questionOption = QuestionAbstractFactory.instance().makeQuestionOption();
							questionOption.setOptionId(resultOption.getInt(1));
							questionOption.setOptionTxt(resultOption.getString(2));
							tempQuestionOptionObj.add(questionOption);
						}
						question.setQuestionOptions(tempQuestionOptionObj);
					}
					surveyQuestions.add(question);
				}

			}
		} catch (SQLException e) {
			logger.error("spcheckIfSurveyPublished throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Successfully created question options");
		return surveyQuestions;
	}

	public long checkSurveySubmission(String BannerID, long CourseId) {
		CallStoredProcedure proc = null;
		long studentSubmission = 0;
		try {
			proc = new CallStoredProcedure("spcheckIfStudentCompletedSurvey(?, ?, ?)");
			proc.setParameter(1, BannerID);
			proc.setParameter(2, CourseId);
			proc.registerOutputParameterLong(3);
			proc.execute();
			studentSubmission = proc.getStatement().getLong(3);

		} catch (SQLException e) {
			logger.error("spCreateQuestion(spcheckIfStudentCompletedSurvey throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return studentSubmission;
	}

	public boolean createStudentResponse(String bannerId, long courseId, String response[]) throws SQLException {
		CallStoredProcedure proc = null;
		try {
			for (int i = 0; i < response.length; i++) {
				String responseArray[] = response[i].split("-");
				proc = new CallStoredProcedure("spCreateSurveyResponse(?, ?, ?, ?)");
				proc.setParameter(1, bannerId);
				proc.setParameter(2, courseId);
				proc.setParameter(3, responseArray[0]);
				proc.setParameter(4, responseArray[1]);
				proc.execute();
			}
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	public void deleteResponse(String BannerID, long CourseId) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDeleteSurveyResponse(?, ?)");
			proc.setParameter(1, BannerID);
			proc.setParameter(2, CourseId);
			proc.execute();

		} catch (SQLException e) {
			logger.error("spDeleteSurveyResponse throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}
}
