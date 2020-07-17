package CSCI5308.GroupFormationTool.Survey;

public class SurveyFactory extends SurveyAbstractFactory {

	public ISurvey makeSurvey() {
		return new Survey();
	}

	public ISurveyPersistence makeSurveyDB() {
		return new SurveyDB();
	}

	public ISurveyStudentPersistence makeStudentSurveyDB() {
		return new SurveyStudentDB();
	}

	public ISurvey makeSurveyWithCourseID(ISurveyPersistence surveyDB, long courseID) {
		return new Survey(surveyDB, courseID);
	}
}
