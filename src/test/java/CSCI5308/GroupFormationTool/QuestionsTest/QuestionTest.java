package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponse;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class QuestionTest {

	@Test
	public void getInstructorID() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setInstructorID((long) 1);
		assertTrue(1 == ques.getInstructorID());
	}

	@Test
	public void setInstructorID() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setInstructorID((long) 1);
		assertTrue(1 == ques.getInstructorID());
	}

	@Test
	public void getQuesID() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionID(1);
		assertTrue(1 == ques.getQuestionID());
	}

	@Test
	public void setQuesID() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionID(1);
		assertTrue(1 == ques.getQuestionID());
	}

	@Test
	public void getQuesTitle() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionTitle("Java");
		assertTrue(ques.getQuestionTitle().equals("Java"));
	}

	@Test
	public void setQuesTitle() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionTitle("Java");
		assertTrue(ques.getQuestionTitle().equals("Java"));
	}

	@Test
	public void getQuesType() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionType("Numeric");
		assertTrue(ques.getQuestionType().equals("Numeric"));
	}

	@Test
	public void setQuesType() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionType("Numeric");
		assertTrue(ques.getQuestionType().equals("Numeric"));
	}

	@Test
	public void getQuesDateTime() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionDateTime("2020-06-10 00:00:00");
		assertTrue(ques.getQuestionDateTime().equals("2020-06-10 00:00:00"));
	}

	@Test
	public void setQuesDateTime() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionDateTime("2020-06-10 00:00:00");
		assertTrue(ques.getQuestionDateTime().equals("2020-06-10 00:00:00"));
	}

	@Test
	public void getQuesText() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionText("how familiar with java?");
		assertTrue(ques.getQuestionText().equals("how familiar with java?"));
	}

	@Test
	public void setQuesText() {
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		ques.setQuestionText("how familiar with java?");
		assertTrue(ques.getQuestionText().equals("how familiar with java?"));
	}

	@Test
	public void deleteQuestionTest() {
		IQuestionPersistence questionDBMock = QuestionsSystemConfigTest.instance().getQuestionDBMock();
		boolean response = questionDBMock.deleteQuestion(-1);
		assertTrue(response);
	}

	@Test
	public void getAllResponsesTest() {
		IQuestionResponsePersistence responseDBMock = QuestionsSystemConfigTest.instance()
				.getReponseDBMock();
		List<IQuestionResponse> responseList = responseDBMock.getAllResponsesOfQuestion(-1);
		assertTrue(null != responseList && responseList.size() > 0);
	}

	@Test
	public void checkIfQuestionHasResponseTest() {
		IQuestionResponsePersistence responseDBMock = QuestionsSystemConfigTest.instance()
				.getReponseDBMock();
		List<IQuestionResponse> responseList = responseDBMock.getAllResponsesOfQuestion(-1);
		assertTrue(null != responseList && responseList.size() > 0);
	}

	@Test
	public void createQuestionTest() {
		IQuestionPersistence questionDBMock = QuestionsSystemConfigTest.instance().getQuestionDBMock();
		IQuestion ques = QuestionAbstractFactory.instance().makeQuestion();
		questionDBMock.createQuestion(ques);
		assertTrue(ques.getQuestionID() == 1);
	}
}