package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;

public class QuestionListManagerTest {

	@Test
	public void sortQuesTest() {
		List<IQuestion> questionList;
		IQuestionPersistence questionDBMock = QuestionsSystemConfigPersistenceTest.instance().getQuestionDBMock();
		questionList = questionDBMock.sortByDate("B000000");
		assertTrue(questionList != null && questionList.size()>0);
		questionList = questionDBMock.sortByTitle("B000000");
		assertTrue(questionList != null && questionList.size()>0);
	}

	@Test
	public void displayQuestions() {
		IQuestionPersistence questionDBMock = QuestionsSystemConfigPersistenceTest.instance().getQuestionDBMock();
		List<IQuestion> questionList = questionDBMock.displayQuestions("B000000");
		assertTrue(null != questionList && questionList.size() > 0);
	}
}