package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Questions.IQuestionManagerDB;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;
@SpringBootTest
@SuppressWarnings("deprecation")
public class QuestionTest{

	
	@Test
	public void getInstructorID() {
		Question ques=new Question();
		ques.setInstructorID((long) 1);
		Assert.isTrue(1==ques.getInstructorID());
	}
	@Test
	public void setInstructorID() {
		Question ques=new Question();
		ques.setInstructorID((long) 1);
		Assert.isTrue(1==ques.getInstructorID());
	}
	@Test
	public void getQuesID() {
		Question ques=new Question();
		ques.setQuesID(1);
		Assert.isTrue(1==ques.getQuesID());
	}
	@Test
	public void setQuesID() {
		Question ques=new Question();
		ques.setQuesID(1);
		Assert.isTrue(1==ques.getQuesID());
	}
	@Test
	public void getQuesTitle() {
		Question ques=new Question();
		ques.setQuesTitle("Java");
		Assert.isTrue(ques.getQuesTitle().equals("Java"));
	}
	@Test
	public void setQuesTitle() {
		Question ques=new Question();
		ques.setQuesTitle("Java");
		Assert.isTrue(ques.getQuesTitle().equals("Java"));
	}
	@Test
	public void getQuesType() {
		Question ques=new Question();
		ques.setQuesType("Numeric");
		Assert.isTrue(ques.getQuesType().equals("Numeric"));
	}
	@Test
	public void setQuesType() {
		Question ques=new Question();
		ques.setQuesType("Numeric");
		Assert.isTrue(ques.getQuesType().equals("Numeric"));
	}
	@Test
	public void getQuesDateTime() {
		Question ques=new Question();
		ques.setQuesDateTime("2020-06-10 00:00:00");
		Assert.isTrue(ques.getQuesDateTime().equals("2020-06-10 00:00:00"));
	}
	@Test
	public void setQuesDateTime() {
		Question ques=new Question();
		ques.setQuesDateTime("2020-06-10 00:00:00");
		Assert.isTrue(ques.getQuesDateTime().equals("2020-06-10 00:00:00"));
	}
	@Test
	public void getQuesText() {
		Question ques=new Question();
		ques.setQuesText("how familiar with java?");
		Assert.isTrue(ques.getQuesText().equals("how familiar with java?"));
	}
	@Test
	public void setQuesText() {
		Question ques=new Question();
		ques.setQuesText("how familiar with java?");
		Assert.isTrue(ques.getQuesText().equals("how familiar with java?"));
	}
	
	@Test
	public void deleteQuestionTest() {
		IQuestionPersistence questionDBMock = new QuestionDBMock();
		boolean response = questionDBMock.deleteQuestion(-1);
		Assert.isTrue(response);
	}
	
	@Test
	public void getAllResponsesTest() {
		IQuestionResponsePersistence responseDBMock = new QuestionResponseDBMock();
		List<QuestionResponse> responseList = responseDBMock.getAllResponsesOfQuestion(-1);
		Assert.isTrue(responseList != null && responseList.size() > 0);
	}
	
	@Test
	public void checkIfQuestionHasResponseTest() {
		IQuestionResponsePersistence responseDBMock = new QuestionResponseDBMock();
		List<QuestionResponse> responseList = responseDBMock.getAllResponsesOfQuestion(-1);
		Assert.isTrue(responseList != null && responseList.size() > 0);
	}

	@Test
	public void createQuestionTest() {
		IQuestionPersistence questionDBMock = new QuestionDBMock();
		Question question = new Question();
		questionDBMock.createQuestion(question);
		assertTrue(question.getQuesID()==1);
	}
}
