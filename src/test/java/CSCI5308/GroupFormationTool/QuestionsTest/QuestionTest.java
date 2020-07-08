package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class QuestionTest{

	@Test
	public void getInstructorID() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setInstructorID((long) 1);
		assertTrue(1==ques.getInstructorID());
	}
	
	@Test
	public void setInstructorID() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setInstructorID((long) 1);
		assertTrue(1==ques.getInstructorID());
	}
	
	@Test
	public void getQuesID() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionID(1);
		assertTrue(1==ques.getQuestionID());
	}
	
	@Test
	public void setQuesID() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionID(1);
		assertTrue(1==ques.getQuestionID());
	}
	
	@Test
	public void getQuesTitle() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionTitle("Java");
		assertTrue(ques.getQuestionTitle().equals("Java"));
	}
	
	@Test
	public void setQuesTitle() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionTitle("Java");
		assertTrue(ques.getQuestionTitle().equals("Java"));
	}
	
	@Test
	public void getQuesType() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionType("Numeric");
		assertTrue(ques.getQuestionType().equals("Numeric"));
	}
	
	@Test
	public void setQuesType() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionType("Numeric");
		assertTrue(ques.getQuestionType().equals("Numeric"));
	}
	
	@Test
	public void getQuesDateTime() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionDateTime("2020-06-10 00:00:00");
		assertTrue(ques.getQuestionDateTime().equals("2020-06-10 00:00:00"));
	}
	
	@Test
	public void setQuesDateTime() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionDateTime("2020-06-10 00:00:00");
		assertTrue(ques.getQuestionDateTime().equals("2020-06-10 00:00:00"));
	}
	
	@Test
	public void getQuesText() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionText("how familiar with java?");
		assertTrue(ques.getQuestionText().equals("how familiar with java?"));
	}
	
	@Test
	public void setQuesText() {
		Question ques=QuestionsSystemConfigTest.instance().getQuestion();
		ques.setQuestionText("how familiar with java?");
		assertTrue(ques.getQuestionText().equals("how familiar with java?"));
	}
	
	@Test
	public void deleteQuestionTest() {
		IQuestionPersistence questionDBMock = QuestionsSystemConfigPersistenceTest.instance().getQuestionDBMock();
		boolean response = questionDBMock.deleteQuestion(-1);
		assertTrue(response);
	}
	
	@Test
	public void getAllResponsesTest() {
		IQuestionResponsePersistence responseDBMock = QuestionsSystemConfigPersistenceTest.instance().getReponseDBMock();
		List<QuestionResponse> responseList = responseDBMock.getAllResponsesOfQuestion(-1);
		assertTrue(null != responseList && responseList.size() > 0);
	}
	
	@Test
	public void checkIfQuestionHasResponseTest() {
		IQuestionResponsePersistence responseDBMock = QuestionsSystemConfigPersistenceTest.instance().getReponseDBMock();
		List<QuestionResponse> responseList = responseDBMock.getAllResponsesOfQuestion(-1);
		assertTrue(null != responseList && responseList.size() > 0);
	}

	@Test
	public void createQuestionTest() {
		IQuestionPersistence questionDBMock = QuestionsSystemConfigPersistenceTest.instance().getQuestionDBMock();
		Question question = QuestionsSystemConfigTest.instance().getQuestion();
		questionDBMock.createQuestion(question);
		assertTrue(question.getQuestionID()==1);
	}
}