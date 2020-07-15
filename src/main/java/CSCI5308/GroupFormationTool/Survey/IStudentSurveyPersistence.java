package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public interface IStudentSurveyPersistence {
	public List<IQuestion> viewSurveyQuestions(long courseID);

	public long checkSurveySubmission(String BannerID, long CourseId);

	public boolean createStudentResponse(String BannerID, long CourseID, String ResponseArray[]);

}
