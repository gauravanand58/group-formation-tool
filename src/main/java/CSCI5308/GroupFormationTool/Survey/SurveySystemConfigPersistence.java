package CSCI5308.GroupFormationTool.Survey;


public class SurveySystemConfigPersistence {
	private static SurveySystemConfigPersistence uniqueInstance = null;

	private IQuestionSurveyRelationshipPersistence questionSurveyDB;
	
	private SurveySystemConfigPersistence() {
		questionSurveyDB = new QuestionSurveyRelationshipPersistence();
		
	}

	
	public static SurveySystemConfigPersistence instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new SurveySystemConfigPersistence();
		}
		return uniqueInstance;
	}


	public IQuestionSurveyRelationshipPersistence getQuestionSurveyDB() {
		return questionSurveyDB;
	}

	
}
