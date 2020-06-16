package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.Response;

public class QuestionTest {
	
	@Test
	public void ConstructorTests() {
		Question question = new Question();
		assertTrue(question.getInstructorID() == -1);
		assertTrue(question.getQuesID() == -1);
		assertTrue(question.getQuesDateTime().isEmpty());
		assertTrue(question.getQuesText().isEmpty());
		assertTrue(question.getQuesTitle().isEmpty());
		assertTrue(question.getQuesType().isEmpty());
	}
	
	@Test
	public void getInstructorIDTest() {
		Question question = new Question();
		question.setInstructorID(0);
		assertTrue(question.getInstructorID() == 0);
	}
	
	@Test
	public void setInstructorIDTest() {
		Question question = new Question();
		question.setInstructorID(0);
		assertTrue(question.getInstructorID() == 0);
	}
	
	@Test
	public void getQuesIDTest() {
		Question question = new Question();
		question.setQuesID(0);
		assertTrue(question.getQuesID() == 0);
	}
	
	@Test
	public void setQuesIDTest() {
		Question question = new Question();
		question.setQuesID(0);
		assertTrue(question.getQuesID() == 0);
	}
	
	@Test
	public void getQuesDateTimeTest() {
		Question question = new Question();
		question.setQuesDateTime("0000-00-00 00:00:00");
		assertTrue(question.getQuesDateTime().equals("0000-00-00 00:00:00"));
	}
	
	@Test
	public void setQuesDateTimeTest() {
		Question question = new Question();
		question.setQuesDateTime("0000-00-00 00:00:00");
		assertTrue(question.getQuesDateTime().equals("0000-00-00 00:00:00"));
	}
	
	@Test
	public void getQuesTextTest() {
		Question question = new Question();
		question.setQuesText("Test Question Text");
		assertTrue(question.getQuesText().equals("Testing Question Text"));
	}
	
	@Test
	public void setQuesTextTest() {
		Question question = new Question();
		question.setQuesText("Test Question Text");
		assertTrue(question.getQuesText().equals("Testing Question Text"));
	}
	
	@Test
	public void getQuesTitleTest() {
		Question question = new Question();
		question.setQuesTitle("Test Question Title");
		assertTrue(question.getQuesTitle().equals("Test Question Title"));
	}
	
	@Test
	public void setQuesTitleTest() {
		Question question = new Question();
		question.setQuesTitle("Test Question Title");
		assertTrue(question.getQuesTitle().equals("Test Question Title"));
	}
	
	@Test
	public void getQuesTypeTest() {
		Question question = new Question();
		question.setQuesType("Test Question Type");
		assertTrue(question.getQuesType().equals("Test Question Type"));
	}
	
	@Test
	public void setQuesTypeTest() {
		Question question = new Question();
		question.setQuesType("Test Question Type");
		assertTrue(question.getQuesType().equals("Test Question Type"));
	}
	
	@Test
	public void deleteQuestionTest() {
		IQuestionPersistence questionDBMock = new QuestionDBMock();
		Question question = new Question();
		boolean response = questionDBMock.deleteQuestion(question.getQuesID());
		assertTrue(response);
	}
	
	@Test
	public void getAllResponsesTest() {
		IResponsePersistence responseDBMock = new ResponseDBMock();
		Question question = new Question();
		List<Response> responseList = responseDBMock.getAllResponsesOfQuestion(question.getQuesID());
		assertTrue(responseList != null && responseList.size() > 0);
	}
	
	@Test
	public void checkIfQuestionHasResponseTest() {
		IResponsePersistence responseDBMock = new ResponseDBMock();
		Question question = new Question();
		List<Response> responseList = responseDBMock.getAllResponsesOfQuestion(question.getQuesID());
		assertTrue(responseList != null && responseList.size() > 0);
	}
}
