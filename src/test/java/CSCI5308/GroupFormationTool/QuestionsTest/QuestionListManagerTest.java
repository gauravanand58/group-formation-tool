package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.Question;

@SuppressWarnings("deprecation")
public class QuestionListManagerTest {

	@Test
	public void sortQuesTest() {
		List<Question> questionList;
		IQuestionPersistence questionDBMock = new QuestionDBMock();
		questionList = questionDBMock.sortByDate("B000000");
		Assert.isTrue(questionList != null && questionList.size()>0);
		questionList = questionDBMock.sortByTitle("B000000");
		Assert.isTrue(questionList != null && questionList.size()>0);
	}

	
	@Test
	public void displayQuestions() {
		IQuestionPersistence questionDBMock = new QuestionDBMock();
		List<Question> questionList = questionDBMock.displayQuestions("B000000");
		Assert.isTrue(questionList != null && questionList.size()>0);
	}
	
}
