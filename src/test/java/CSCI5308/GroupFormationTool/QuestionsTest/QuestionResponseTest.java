package CSCI5308.GroupFormationTool.QuestionsTest;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

@SuppressWarnings("deprecation")
public class QuestionResponseTest {
	
	@Test
	public void getIdTest() {
		QuestionResponse response = new QuestionResponse();
		response.setId(0);
		Assert.isTrue(response.getId() == 0);
	}
	
	@Test
	public void setIdTest() {
		QuestionResponse response = new QuestionResponse();
		response.setId(0);
		Assert.isTrue(response.getId() == 0);
	}
	
	@Test
	public void getResponseTextTest() {
		QuestionResponse response = new QuestionResponse();
		response.setResponseText("Test Response Text");
		Assert.isTrue(response.getResponseText().equals("Test Response Text"));
	}
	
	@Test
	public void setResponseTextTest() {
		QuestionResponse response = new QuestionResponse();
		response.setResponseText("Test Response Text");
		Assert.isTrue(response.getResponseText().equals("Test Response Text"));
	}
}
