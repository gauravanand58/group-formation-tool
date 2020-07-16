package CSCI5308.GroupFormationTool.Survey;

public class SurveyFactory extends SurveyAbstractFactory{

	public ISurvey makeSurvey() {
		return new Survey();
	}
	
	public ISurveyPersistence makeSurveyDB() {
		return new SurveyDB();
	}

	public IStudentSurveyPersistence makeStudentSurveyDB() {
		return new StudentSurveyDB();
	}	
}
