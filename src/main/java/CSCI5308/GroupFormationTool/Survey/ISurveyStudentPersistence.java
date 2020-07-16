package CSCI5308.GroupFormationTool.Survey;

import java.sql.SQLException;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public interface ISurveyStudentPersistence {
	public List<IQuestion> viewSurveyQuestions(long courseId);

	public long checkSurveySubmission(String bannerId, long courseId);

	public boolean createStudentResponse(String bannerId, long courseId, String responseArray[]) throws SQLException;
	
	public void deleteResponse(String bannerId, long courseId);

}
