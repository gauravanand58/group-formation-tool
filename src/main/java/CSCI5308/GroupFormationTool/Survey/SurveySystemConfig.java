package CSCI5308.GroupFormationTool.Survey;

public class SurveySystemConfig {
	private static SurveySystemConfig uniqueInstance = null;

	private ISurveyPersistence surveyDB;
	private ISurveyStudentPersistence studentSurveyDB;

	private SurveySystemConfig() {
		setSurveyDB(SurveyAbstractFactory.instance().makeSurveyDB());
		studentSurveyDB = SurveyAbstractFactory.instance().makeStudentSurveyDB();
	}

	public static SurveySystemConfig instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new SurveySystemConfig();
		}
		return uniqueInstance;
	}

	public ISurveyStudentPersistence getStudentSurveyDB() {
		return studentSurveyDB;
	}

	public void setStudentSurveyDB(ISurveyStudentPersistence studentSurveyDB) {
		this.studentSurveyDB = studentSurveyDB;
	}

	public ISurveyPersistence getSurveyDB() {
		return surveyDB;
	}

	public void setSurveyDB(ISurveyPersistence surveyDB) {
		this.surveyDB = surveyDB;
	}
}
