package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionResponse;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class QuestionResponseTest {

	@Test
	public void getIdTest() {
		IQuestionResponse response = QuestionAbstractFactory.instance().makeQuestionResponse();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}

	@Test
	public void setIdTest() {
		IQuestionResponse response = QuestionAbstractFactory.instance().makeQuestionResponse();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}

	@Test
	public void getResponseTextTest() {
		IQuestionResponse response = QuestionAbstractFactory.instance().makeQuestionResponse();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}

	@Test
	public void setResponseTextTest() {
		IQuestionResponse response = QuestionAbstractFactory.instance().makeQuestionResponse();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
}