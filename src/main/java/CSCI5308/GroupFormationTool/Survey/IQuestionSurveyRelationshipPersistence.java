package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.Question;

public interface IQuestionSurveyRelationshipPersistence {
	public List<Question> loadQUestionsBySurveyId(long surveyId);
}
