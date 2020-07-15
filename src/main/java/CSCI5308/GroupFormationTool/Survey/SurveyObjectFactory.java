package CSCI5308.GroupFormationTool.Survey;

public class SurveyObjectFactory {
	public static IStudentSurveyPersistence objDBFactory(SurveyPersistenceAbstractFactory obj) {
		return obj.createsurveyDB();
	}
}
