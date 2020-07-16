package CSCI5308.GroupFormationTool.SurveyTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionsSystemConfig;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;

public class SurveyDBMock implements ISurveyPersistence {

	public List<IQuestion> loadQuestionsByCourseId(long courseId) {
		List<IQuestion> list = new ArrayList<>();
		list.add(QuestionsSystemConfig.instance().getQuestion());
		return list;
	}

	public List<IQuestion> getAvailableQuestions(long surveyId, long courseId, long instructorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addQuestionToSurvey(IQuestion question, long courseId) {
		// TODO Auto-generated method stub

	}

	public void loadSurveyByCourseID(ISurvey survey, long courseId) {
		// TODO Auto-generated method stub

	}

	public boolean publishSurvey(long surveyID) {
		if (surveyID == -1) {
			return true;
		}
		return false;
	}

}
