package CSCI5308.GroupFormationTool.SurveyTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.Survey;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyDB;
import CSCI5308.GroupFormationTool.Survey.SurveyStudentDB;

public class SurveyFactoryTest {
	@Test
	public void makeSurvey() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		assertTrue(null != survey);
	}
	
	@Test
	public void makeSurveyDB() {
		ISurveyPersistence surveyDB = SurveyAbstractFactory.instance().makeSurveyDB();
		assertTrue(null != surveyDB);
	}

	@Test
	public void makeStudentSurveyDB() {
		ISurveyStudentPersistence surveyStudentDB = SurveyAbstractFactory.instance().makeStudentSurveyDB();
		assertTrue(null != surveyStudentDB);
	}

	@Test
	public void makeSurveyWithCourseID() {
		ISurveyPersistence surveyDBMock = SurveyTestSystemConfig.instance().getSurveyDBMock();
		ISurvey survey = SurveyAbstractFactory.instance().makeSurveyWithCourseID(surveyDBMock, -1);
		assertTrue(null != survey);
	}
}
