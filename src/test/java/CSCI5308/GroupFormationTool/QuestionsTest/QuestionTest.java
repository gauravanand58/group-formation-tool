package CSCI5308.GroupFormationTool.QuestionsTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Questions.Question;
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
	
}
