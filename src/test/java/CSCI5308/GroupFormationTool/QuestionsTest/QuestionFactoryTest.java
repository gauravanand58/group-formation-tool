package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.IQuestionListManager;
import CSCI5308.GroupFormationTool.Questions.IQuestionOption;
import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponse;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class QuestionFactoryTest {
	
	@Test
	public void makeQuestionDB() {
		IQuestionPersistence questionDB=QuestionAbstractFactory.instance().makeQuestionDB();
		assertTrue(null != questionDB);
	}

	@Test
	public void makeReponseDB() {
		IQuestionResponsePersistence questionResponseDB=QuestionAbstractFactory.instance().makeReponseDB();
		assertTrue(null != questionResponseDB);
	}
	
	@Test
	public void makeQuestionOptionDB() {
		IQuestionOptionPersistence questionOptionDB=QuestionAbstractFactory.instance().makeQuestionOptionDB();
		assertTrue(null != questionOptionDB);
	}

	@Test
	public void makeQuestionListManager() {
		IQuestionListManager questionListManager=QuestionAbstractFactory.instance().makeQuestionListManager();
		assertTrue(null != questionListManager);
	}
	
	@Test
	public void makeQuestion() {
		IQuestion question=QuestionAbstractFactory.instance().makeQuestion();
		assertTrue(null != question);
	}

	@Test
	public void makeQuestionOption() {
		IQuestionOption questionOption=QuestionAbstractFactory.instance().makeQuestionOption();
		assertTrue(null != questionOption);
	}

	@Test
	public void makeLoadedQuestion() {
		IQuestionPersistence questionPersistence=QuestionAbstractFactory.instance().makeQuestionDB();
		IQuestion question=QuestionAbstractFactory.instance().makeLoadedQuestion(questionPersistence, -1);
		assertTrue(null != question);
	}

	@Test
	public void makeQuestionResponse() {
		IQuestionResponse questionResponse=QuestionAbstractFactory.instance().makeQuestionResponse();
		assertTrue(null != questionResponse);
	}

}
