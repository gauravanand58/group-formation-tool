package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;

public class SurveyTestSystemConfig {
	private static SurveyTestSystemConfig uniqueInstance = null;
	
	private ISurveyPersistence surveyDBMock;
	private ISurveyStudentPersistence surveyStudentDBMock;
	
	private SurveyTestSystemConfig() {
		surveyDBMock = new SurveyDBMock();
		surveyStudentDBMock = new SurveyStudentDBMock();
	}
	
	public static SurveyTestSystemConfig instance() {
		if(uniqueInstance == null) {
			uniqueInstance = new SurveyTestSystemConfig();
		}
		return uniqueInstance;
	}

	public ISurveyPersistence getSurveyDBMock() {
		return surveyDBMock;
	}

	public void setSurveyDBMock(ISurveyPersistence surveyDBMock) {
		this.surveyDBMock = surveyDBMock;
	}

	public ISurveyStudentPersistence getSurveyStudentDBMock() {
		return surveyStudentDBMock;
	}

	public void setSurveyStudentDBMock(ISurveyStudentPersistence surveyStudentDBMock) {
		this.surveyStudentDBMock = surveyStudentDBMock;
	}
}
