package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class SurveyFactoryMock extends SurveyAbstractFactory {

	public ISurvey makeSurvey() {
		return SurveyAbstractFactory.instance().makeSurvey();
	}

	public ISurvey makeSurveyWithCourseID(ISurveyPersistence surveyDB, long courseID) {
		return SurveyAbstractFactory.instance().makeSurveyWithCourseID(surveyDB, courseID);
	}

	public ISurveyPersistence makeSurveyDB() {
		return SurveyTestSystemConfig.instance().getSurveyDBMock();
	}

	public ISurveyStudentPersistence makeStudentSurveyDB() {
		return SurveyTestSystemConfig.instance().getSurveyStudentDBMock();
	}
}
