package CSCI5308.GroupFormationTool.SurveyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveyStudentDB;

public class SurveyStudentDBTest {
	List<IQuestion> surveyQuestions;
	String[] responseArray = { "2-none", "3-none" };
	ISurveyStudentPersistence studentSurveyMock = mock(SurveyStudentDB.class);

	SurveyStudentDBTest() {
		IQuestion question = QuestionAbstractFactory.instance().makeQuestion();
		surveyQuestions = new ArrayList<IQuestion>();
		question.setQuestionID(1);
		question.setQuestionText("Favourite Course");
		question.setQuestionType("numeric");
		surveyQuestions.add(question);
	}

	@Test
	public void viewSurveyQuestionsTest() {
		when(studentSurveyMock.viewSurveyQuestions(1)).thenReturn(surveyQuestions);
		assertEquals(studentSurveyMock.viewSurveyQuestions(1), surveyQuestions);
		verify(studentSurveyMock).viewSurveyQuestions(1);
	}

	@Test
	public void checkSurveySubmissionTest() {
		when(studentSurveyMock.checkSurveySubmission("B000000", 3)).thenReturn(1L);
		assertEquals(studentSurveyMock.checkSurveySubmission("B000000", 3), 1L);
		verify(studentSurveyMock).checkSurveySubmission("B000000", 3);
	}

	@Test
	public void createStudentResponseTest() throws SQLException {
		when(studentSurveyMock.createStudentResponse("B000000", 3, responseArray)).thenReturn(true);
		assertTrue(studentSurveyMock.createStudentResponse("B000000", 3, responseArray));
	}
}
