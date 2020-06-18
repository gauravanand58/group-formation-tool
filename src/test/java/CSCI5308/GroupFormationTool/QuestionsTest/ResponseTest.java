package CSCI5308.GroupFormationTool.QuestionsTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import CSCI5308.GroupFormationTool.Questions.Response;

public class ResponseTest {
	
	@Test
	public void getIdTest() {
		Response response = new Response();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}
	
	@Test
	public void setIdTest() {
		Response response = new Response();
		response.setId(0);
		assertTrue(response.getId() == 0);
	}
	
	@Test
	public void getResponseTextTest() {
		Response response = new Response();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
	
	@Test
	public void setResponseTextTest() {
		Response response = new Response();
		response.setResponseText("Test Response Text");
		assertTrue(response.getResponseText().equals("Test Response Text"));
	}
	
}
