package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionManagerDB;

public class QuestionManagerServiceTest {

	@Test
	public void sortQues() {
		IQuestionManagerDB dao=new QuestionManagerDBMock();
		assertNotNull(dao.sortByTitle("B-000000"));
		assertNotNull(dao.sortByDate("B-000000"));
		assertNull(dao.sortByTitle("B-000001"));
		assertNull(dao.sortByDate("B-000001"));
	}
}
