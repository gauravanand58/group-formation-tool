package CSCI5308.GroupFormationTool.Survey;

import java.sql.SQLException;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.Question;

public interface IStudentSurveyPersistence {
	public List<Question> viewSurveyQuestions(long courseID);

	public long checkSurveySubmission(String BannerID, long CourseId);

	public boolean createStudentResponse(String BannerID, long CourseID, String ResponseArray[]) throws SQLException;
	
	public void deleteResponse(String BannerID, long CourseId);

}
