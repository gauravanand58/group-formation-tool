package CSCI5308.GroupFormationTool.SurveyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionsSystemConfig;
import CSCI5308.GroupFormationTool.Survey.IStudentSurveyPersistence;
import CSCI5308.GroupFormationTool.Survey.StudentSurveyDB;

public class StudentSurveyDBMock {
	List<IQuestion> surveyQuestions;
	String[] responseArray = {"2-none","3-none"};
	IStudentSurveyPersistence studentSurveyMock = mock(StudentSurveyDB.class);

	StudentSurveyDBMock() {
		IQuestion question = QuestionsSystemConfig.instance().getQuestion();
		surveyQuestions = new ArrayList<IQuestion>();
		question.setQuestionID(1);
		question.setQuestionText("Favourite Course");
		question.setQuestionType("numeric");
		surveyQuestions.add(question);
		
	}

	@Test
	public void viewSurveyQuestions() {
		when(studentSurveyMock.viewSurveyQuestions(1)).thenReturn(surveyQuestions);
		assertEquals(studentSurveyMock.viewSurveyQuestions(1), surveyQuestions);
		verify(studentSurveyMock).viewSurveyQuestions(1);
	}

	@Test
	public void checkSurveySubmission() {
		when(studentSurveyMock.checkSurveySubmission("B000000",3)).thenReturn(1L);
		assertEquals(studentSurveyMock.checkSurveySubmission("B000000",3), 1L);
		verify(studentSurveyMock).checkSurveySubmission("B000000",3);
	}

	@Test
	public void createStudentResponse() {
		when(studentSurveyMock.createStudentResponse("B000000",3,responseArray)).thenReturn(true);
		assertTrue(studentSurveyMock.createStudentResponse("B000000",3, responseArray));
	}

}
