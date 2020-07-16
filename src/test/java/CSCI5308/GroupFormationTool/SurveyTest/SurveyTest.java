package CSCI5308.GroupFormationTool.SurveyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class SurveyTest {
	@Test
	public void ConstructorsTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		assertEquals(-1, survey.getSurveyId());
		assertEquals(-1, survey.getCourseId());
		assertEquals(-1, survey.getInstructorId());
		assertEquals(false, survey.isPublished());
		
		ISurveyPersistence surveyDBMock = SurveyTestSystemConfig.instance().getSurveyDBMock();
		survey = SurveyAbstractFactory.instance().makeSurveyWithCourseID(surveyDBMock, -1);
		assertEquals(-1, survey.getCourseId());
	}
	
	@Test
	public void getSurveyIdTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setSurveyId(0);
		assertEquals(0, survey.getSurveyId());
	}
	
	@Test
	public void setSurveyIdTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setSurveyId(0);
		assertEquals(0, survey.getSurveyId());
	}
	
	@Test
	public void getInstructorIdTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setInstructorId(0);
		assertEquals(0, survey.getInstructorId());
	}
	
	@Test
	public void setInstructorIdTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setInstructorId(0);
		assertEquals(0, survey.getInstructorId());
	}
	
	@Test
	public void getCourseidTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setCourseId(0);
		assertEquals(0, survey.getCourseId());
	}
	
	@Test
	public void setCourseidTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setCourseId(0);
		assertEquals(0, survey.getCourseId());
	}
	
	@Test
	public void isPublishedTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setPublished(true);
		assertEquals(true, survey.isPublished());
	}
	
	@Test
	public void setPublishedTest() {
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		survey.setPublished(true);
		assertEquals(true, survey.isPublished());
	}
	
	@Test
	public void loadQuestionsByCourseIdTest() {
		ISurveyPersistence surveyDBMock = SurveyTestSystemConfig.instance().getSurveyDBMock();
		List<IQuestion> list = surveyDBMock.loadQuestionsByCourseId(-1);
		assertEquals(1, list.size());
	}
	
	@Test
	public void publishSurveyTest() {
		ISurveyPersistence surveyDBMock = SurveyTestSystemConfig.instance().getSurveyDBMock();
		assertEquals(true, surveyDBMock.publishSurvey(-1));
	}
	
	@Test
	public void submitResponseTest() throws SQLException {
		String[] responseArray = {"Response 1", "Response 2"};
		ISurveyStudentPersistence surveyStudentDBMock = SurveyTestSystemConfig.instance().getSurveyStudentDBMock();
		assertEquals(true, surveyStudentDBMock.createStudentResponse("B-00000", -1, responseArray));
	}
}
