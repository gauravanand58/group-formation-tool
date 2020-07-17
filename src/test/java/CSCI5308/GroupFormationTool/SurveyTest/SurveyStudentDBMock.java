package CSCI5308.GroupFormationTool.SurveyTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;

public class SurveyStudentDBMock implements ISurveyStudentPersistence {

	@Override
	public List<IQuestion> viewSurveyQuestions(long courseId) {
		List<IQuestion> list = new ArrayList<>();
		list.add(QuestionAbstractFactory.instance().makeQuestion());
		return list;
	}

	@Override
	public long checkSurveySubmission(String bannerId, long courseId) {
		if(courseId == -1) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean createStudentResponse(String bannerId, long courseId, String[] responseArray) {
		if (courseId == -1) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteResponse(String bannerId, long courseId) {
		List<IQuestion> list = new ArrayList<>();
		list.add(QuestionAbstractFactory.instance().makeQuestion());
		list.clear();
	}
}
