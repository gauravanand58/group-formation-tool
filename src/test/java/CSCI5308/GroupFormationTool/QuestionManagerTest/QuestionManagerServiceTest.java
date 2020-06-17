package CSCI5308.GroupFormationTool.QuestionManagerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestionManagerDB;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionOptions;

public class QuestionManagerServiceTest {

	@Test
	public void sortQuesTest() {
		IQuestionManagerDB dao=new QuestionManagerDBMock();
		assertNotNull(dao.sortByTitle("B-000000"));
		assertNotNull(dao.sortByDate("B-000000"));
		assertNull(dao.sortByTitle("B-000001"));
		assertNull(dao.sortByDate("B-000001"));
	}
	@Test
	public void displayQuesTest() {
		IQuestionManagerDB dao=new QuestionManagerDBMock();
		assertNotNull(dao.displayQues("B-000000"));
		assertNull(dao.displayQues("B-000001"));
	}
	@Test
	public void createQuestionTest() {
		IQuestionManagerDB dao=new QuestionManagerDBMock();
		Question question = new Question();
		question.setInstructorID((long) 1);
		question.setQuesID(1);
		question.setQuesTitle("Java");
		question.setQuesText("How familiar wih java?");
		question.setQuesDateTime("2020-06-10 00:00:00");
		dao.createQuestion(question);
		assertTrue(question.getQuesID()==1);
		assertTrue(question.getQuesTitle()=="Java");
		assertTrue(question.getQuesText()=="How familiar wih java?");
		assertTrue(question.getQuesDateTime()=="2020-06-10 00:00:00");
	}
	@Test
	public void createOptionTest() {
		IQuestionManagerDB dao=new QuestionManagerDBMock();
		QuestionOptions questionOption = new QuestionOptions();
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		dao.createOption(questionOption);
		assertTrue(questionOption.getOptionTxt()=="intermediate");
		assertTrue(questionOption.getOptionScore()=="5");
	}
	
	
}
