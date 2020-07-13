package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.Question;

public interface ISurveyQuestionRelationship {
	public List<Question> loadQuestionsBySurveyId(long surveyId, IQuestionSurveyRelationshipPersistence questionSurveyRelationshipPersistence);
}
