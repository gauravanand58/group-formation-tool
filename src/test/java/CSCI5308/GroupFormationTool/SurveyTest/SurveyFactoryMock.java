package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class SurveyFactoryMock extends SurveyAbstractFactory{

	@Override
	public ISurvey makeSurvey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISurvey makeSurveyWithCourseID(ISurveyPersistence surveyDB, long courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISurveyPersistence makeSurveyDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISurveyStudentPersistence makeStudentSurveyDB() {
		// TODO Auto-generated method stub
		return null;
	}

}
