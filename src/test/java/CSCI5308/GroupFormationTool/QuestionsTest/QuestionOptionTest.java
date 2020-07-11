package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

public class QuestionOptionTest {
	@Test
	void getOptionTxt() {
		QuestionOption questionOption = QuestionsSystemConfigTest.instance().getQuestionOption();
		questionOption.setOptionTxt("a");
		assertTrue(questionOption.getOptionTxt().equals("a"));
	}

	@Test
	void setOptionTxt() {
		QuestionOption questionOption = QuestionsSystemConfigTest.instance().getQuestionOption();
		questionOption.setOptionTxt("a");
		assertTrue(questionOption.getOptionTxt().equals("a"));
	}

	@Test
	void getOptionScore() {
		QuestionOption questionOption = QuestionsSystemConfigTest.instance().getQuestionOption();
		questionOption.setOptionScore("1");
		assertTrue(questionOption.getOptionScore().equals("1"));
	}

	@Test
	void setOptionScore() {
		QuestionOption questionOption = QuestionsSystemConfigTest.instance().getQuestionOption();
		questionOption.setOptionScore("1");
		assertTrue(questionOption.getOptionScore().equals("1"));
	}

	@Test
	public void createOptionTest() {
		IQuestionOptionPersistence questionOptionDBMock = QuestionsSystemConfigPersistenceTest.instance().getQuestionOptionDBMock();
		QuestionOption questionOption = QuestionsSystemConfigTest.instance().getQuestionOption();
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		questionOptionDBMock.createOption(questionOption, 0);
		assertTrue(questionOption.getOptionTxt() == "intermediate");
		assertTrue(questionOption.getOptionScore() == "5");
	}
}