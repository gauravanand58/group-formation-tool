package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.Question;

public class SurveyQuestionRelationship implements ISurveyQuestionRelationship{

	@Override
	public List<Question> loadQuestionsBySurveyId(long surveyId,
			IQuestionSurveyRelationshipPersistence questionSurveyRelationshipPersistence) {
		
		return questionSurveyRelationshipPersistence.loadQUestionsBySurveyId(surveyId);
	}


	
}
