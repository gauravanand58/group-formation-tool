package CSCI5308.GroupFormationTool.Survey;

public abstract class SurveyAbstractFactory {
	private static SurveyAbstractFactory uniqueInstance;

	protected SurveyAbstractFactory() {
	}

	public static SurveyAbstractFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new SurveyFactory();
		}
		return uniqueInstance;
	}

	public void setFactory(SurveyAbstractFactory factory) {
		uniqueInstance = factory;
	}

	public SurveyAbstractFactory getFactory() {
		return uniqueInstance;
	}

	public abstract ISurvey makeSurvey();

	public abstract ISurvey makeSurveyWithCourseID(ISurveyPersistence surveyDB, long courseID);

	public abstract ISurveyPersistence makeSurveyDB();

	public abstract ISurveyStudentPersistence makeStudentSurveyDB();
}
