package CSCI5308.GroupFormationTool.SurveyTest;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;

public class SurveyStudentDBMock implements ISurveyStudentPersistence{

	@Override
	public List<IQuestion> viewSurveyQuestions(long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long checkSurveySubmission(String bannerId, long courseId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean createStudentResponse(String bannerId, long courseId, String[] responseArray) {
		if(courseId == -1) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteResponse(String bannerId, long courseId) {
		// TODO Auto-generated method stub
		
	}
}
