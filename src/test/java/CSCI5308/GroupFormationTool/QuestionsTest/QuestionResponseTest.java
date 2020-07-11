package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class QuestionResponseTest {
	
	@Test
	public void getIdTest() {
		QuestionResponse response = QuestionsSystemConfigTest.instance().getQuestionResponse();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}
	
	@Test
	public void setIdTest() {
		QuestionResponse response = QuestionsSystemConfigTest.instance().getQuestionResponse();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}
	
	@Test
	public void getResponseTextTest() {
		QuestionResponse response = QuestionsSystemConfigTest.instance().getQuestionResponse();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
	
	@Test
	public void setResponseTextTest() {
		QuestionResponse response = QuestionsSystemConfigTest.instance().getQuestionResponse();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
}