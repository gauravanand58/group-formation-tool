package CSCI5308.GroupFormationTool.Survey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

public class StudentSurveyDB implements IStudentSurveyPersistence{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Question> viewSurveyQuestions(long courseID) {
		CallStoredProcedure proc = null;
		List<Question> surveyQuestions = new ArrayList<Question>();
		List<QuestionOption> tempQuestionOptionObj;
		Question tempObj;
		QuestionOption tempObj2;
		try {
				proc = new CallStoredProcedure("spcheckIfSurveyPublished(?)");
				proc.setParameter(1, courseID);
				ResultSet results=proc.executeWithResults();
				ResultSet resultOption;
				if(null!=results) {
					
					while(results.next()) {
						tempObj=new Question();
						tempObj.setQuestionID(results.getInt(1));
						tempObj.setQuestionText(results.getString(2));
						tempObj.setQuestionType(results.getString(3));
						
						proc = new CallStoredProcedure("sploadallquestionoptions(?)");
						proc.setParameter(1, results.getInt(1));
						resultOption=proc.executeWithResults();
						if(null!=resultOption) {
							tempQuestionOptionObj=new ArrayList<QuestionOption>();
							while(resultOption.next()) {
								tempObj2=new QuestionOption();
								tempObj2.setOptionId(resultOption.getInt(1));
								tempObj2.setOptionTxt(resultOption.getString(2));
								tempQuestionOptionObj.add(tempObj2);
							}
							tempObj.setQuestionOptions(tempQuestionOptionObj);
						}
						surveyQuestions.add(tempObj);
					}
					
				}
		} catch (SQLException e) {
			logger.error("spcheckIfSurveyPublished(?) throws SQLException:"+e.getMessage());
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
			logger.error("spCreateQuestion(spcheckIfStudentCompletedSurvey(?, ?, ?) throws SQLException:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return studentSubmission;
	}
	
	public boolean createStudentResponse(String BannerID, long CourseID, String ResponseArray[]) {
		CallStoredProcedure proc = null;
		
		try {
			for(int i=0; i<ResponseArray.length;i++) {
				String arr2[]= ResponseArray[i].split("-");
				proc = new CallStoredProcedure("spCreateSurveyResponse(?, ?, ?, ?)");
				proc.setParameter(1, BannerID);
				proc.setParameter(2, CourseID);
				proc.setParameter(3, arr2[0]);
				proc.setParameter(4, arr2[1]);
				proc.execute();
			}
			

		} catch (SQLException e) {
			logger.error("spCreateSurveyResponse(?, ?, ?, ?) throws SQLException:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

}
