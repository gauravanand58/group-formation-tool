package CSCI5308.GroupFormationTool.Survey;



public class SurveySystemConfig {
	private static SurveySystemConfig uniqueInstance = null;
	private IStudentSurveyPersistence studentSurveyDB;

	private SurveySystemConfig() {
		studentSurveyDB = SurveyObjectFactory.objDBFactory(new SurveyDbFactory());
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

}
