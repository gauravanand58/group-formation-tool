package CSCI5308.GroupFormationTool.Survey;

public class SurveySystemConfig {
	private static SurveySystemConfig uniqueInstance = null;
	
	private ISurveyPersistence surveyDB;
	private IStudentSurveyPersistence studentSurveyDB;

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

	public IStudentSurveyPersistence getStudentSurveyDB() {
		return studentSurveyDB;
	}

	public void setStudentSurveyDB(IStudentSurveyPersistence studentSurveyDB) {
		this.studentSurveyDB = studentSurveyDB;
	}

	public ISurveyPersistence getSurveyDB() {
		return surveyDB;
	}

	public void setSurveyDB(ISurveyPersistence surveyDB) {
		this.surveyDB = surveyDB;
	}

}
