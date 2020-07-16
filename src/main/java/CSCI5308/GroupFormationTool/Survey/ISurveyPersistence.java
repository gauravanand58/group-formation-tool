package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public interface ISurveyPersistence {
	public List<IQuestion> loadQuestionsByCourseId(long courseId);

	public List<IQuestion> getAvailableQuestions(long surveyId, long courseId, long instructorId);

	public void addQuestionToSurvey(IQuestion question, long courseId);

	public void loadSurveyByCourseID(ISurvey survey, long courseId);

	public boolean publishSurvey(long surveyID);
}