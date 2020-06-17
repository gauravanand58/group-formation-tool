package CSCI5308.GroupFormationTool.QuestionManagerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestionManagerDB;

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
}
