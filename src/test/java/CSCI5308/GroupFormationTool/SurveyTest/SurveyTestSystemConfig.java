package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class SurveyTestSystemConfig {
	private static SurveyTestSystemConfig uniqueInstance = null;

	private ISurveyPersistence surveyDBMock;
	private ISurveyStudentPersistence surveyStudentDBMock;
	private SurveyAbstractFactory surveyFactoryMock;

	private SurveyTestSystemConfig() {
		surveyDBMock = new SurveyDBMock();
		surveyStudentDBMock = new SurveyStudentDBMock();
		surveyFactoryMock = new SurveyFactoryMock();
	}

	public static SurveyTestSystemConfig instance() {
		if (null == uniqueInstance) {
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

	public SurveyAbstractFactory getSurveyFactoryMock() {
		return surveyFactoryMock;
	}

	public void setSurveyFactoryMock(SurveyAbstractFactory surveyFactoryMock) {
		this.surveyFactoryMock = surveyFactoryMock;
	}
}
