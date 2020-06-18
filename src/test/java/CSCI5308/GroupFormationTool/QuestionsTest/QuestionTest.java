package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
		ques.setQuestionID(1);
		Assert.isTrue(1==ques.getQuestionID());
	}
	
	@Test
	public void setQuesID() {
		Question ques=new Question();
		ques.setQuestionID(1);
		Assert.isTrue(1==ques.getQuestionID());
	}
	
	@Test
	public void getQuesTitle() {
		Question ques=new Question();
		ques.setQuestionTitle("Java");
		Assert.isTrue(ques.getQuestionTitle().equals("Java"));
	}
	
	@Test
	public void setQuesTitle() {
		Question ques=new Question();
		ques.setQuestionTitle("Java");
		Assert.isTrue(ques.getQuestionTitle().equals("Java"));
	}
	
	@Test
	public void getQuesType() {
		Question ques=new Question();
		ques.setQuestionType("Numeric");
		Assert.isTrue(ques.getQuestionType().equals("Numeric"));
	}
	
	@Test
	public void setQuesType() {
		Question ques=new Question();
		ques.setQuestionType("Numeric");
		Assert.isTrue(ques.getQuestionType().equals("Numeric"));
	}
	
	@Test
	public void getQuesDateTime() {
		Question ques=new Question();
		ques.setQuestionDateTime("2020-06-10 00:00:00");
		Assert.isTrue(ques.getQuestionDateTime().equals("2020-06-10 00:00:00"));
	}
	
	@Test
	public void setQuesDateTime() {
		Question ques=new Question();
		ques.setQuestionDateTime("2020-06-10 00:00:00");
		Assert.isTrue(ques.getQuestionDateTime().equals("2020-06-10 00:00:00"));
	}
	
	@Test
	public void getQuesText() {
		Question ques=new Question();
		ques.setQuestionText("how familiar with java?");
		Assert.isTrue(ques.getQuestionText().equals("how familiar with java?"));
	}
	
	@Test
	public void setQuesText() {
		Question ques=new Question();
		ques.setQuestionText("how familiar with java?");
		Assert.isTrue(ques.getQuestionText().equals("how familiar with java?"));
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
		Assert.isTrue(question.getQuestionID()==1);
	}
}
