package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class SurveyFactoryMock extends SurveyAbstractFactory {

	@Override
	public ISurvey makeSurvey() {
		return null;
	}

	@Override
	public ISurvey makeSurveyWithCourseID(ISurveyPersistence surveyDB, long courseID) {
		return null;
	}

	@Override
	public ISurveyPersistence makeSurveyDB() {
		return null;
	}

	@Override
	public ISurveyStudentPersistence makeStudentSurveyDB() {
		return null;
	}

}
