package CSCI5308.GroupFormationTool.QuestionsTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class QuestionResponseTest {
	
	@Test
	public void getIdTest() {
		QuestionResponse response = new QuestionResponse();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}
	
	@Test
	public void setIdTest() {
		QuestionResponse response = new QuestionResponse();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}
	
	@Test
	public void getResponseTextTest() {
		QuestionResponse response = new QuestionResponse();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
	
	@Test
	public void setResponseTextTest() {
		QuestionResponse response = new QuestionResponse();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
	
}
