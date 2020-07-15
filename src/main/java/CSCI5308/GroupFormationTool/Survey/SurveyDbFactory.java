package CSCI5308.GroupFormationTool.Survey;

public class SurveyDbFactory implements SurveyPersistenceAbstractFactory {

	@Override
	public IStudentSurveyPersistence createsurveyDB() {
		return new StudentSurveyDB();
	}

}
