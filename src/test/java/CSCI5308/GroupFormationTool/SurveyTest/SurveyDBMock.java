package CSCI5308.GroupFormationTool.SurveyTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class SurveyDBMock implements ISurveyPersistence {

	public List<IQuestion> loadQuestionsByCourseId(long courseId) {
		List<IQuestion> list = new ArrayList<>();
		list.add(QuestionAbstractFactory.instance().makeQuestion());
		return list;
	}

	public List<IQuestion> getAvailableQuestions(long surveyId, long courseId, long instructorId) {
		List<IQuestion> list = new ArrayList<>();
		list.add(QuestionAbstractFactory.instance().makeQuestion());
		return list;
	}

	public void addQuestionToSurvey(IQuestion question, long courseId) {
		List<IQuestion> list = new ArrayList<>();
		list.add(QuestionAbstractFactory.instance().makeQuestion());
	}

	public void loadSurveyByCourseID(ISurvey survey, long courseId) {
		survey = SurveyAbstractFactory.instance().makeSurvey();
	}

	public boolean publishSurvey(long surveyID) {
		if (surveyID == -1) {
			return true;
		}
		return false;
	}
}
