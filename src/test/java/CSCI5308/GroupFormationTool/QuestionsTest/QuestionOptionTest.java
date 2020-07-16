package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionOption;
import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

public class QuestionOptionTest {
	@Test
	void getOptionTxt() {
		IQuestionOption questionOption = QuestionAbstractFactory.instance().makeQuestionOption();
		questionOption.setOptionTxt("a");
		assertTrue(questionOption.getOptionTxt().equals("a"));
	}

	@Test
	void setOptionTxt() {
		IQuestionOption questionOption = QuestionAbstractFactory.instance().makeQuestionOption();
		questionOption.setOptionTxt("a");
		assertTrue(questionOption.getOptionTxt().equals("a"));
	}

	@Test
	void getOptionScore() {
		IQuestionOption questionOption = QuestionAbstractFactory.instance().makeQuestionOption();
		questionOption.setOptionScore("1");
		assertTrue(questionOption.getOptionScore().equals("1"));
	}

	@Test
	void setOptionScore() {
		IQuestionOption questionOption = QuestionAbstractFactory.instance().makeQuestionOption();
		questionOption.setOptionScore("1");
		assertTrue(questionOption.getOptionScore().equals("1"));
	}

	@Test
	public void createOptionTest() {
		IQuestionOptionPersistence questionOptionDBMock = QuestionsSystemConfigTest.instance()
				.getQuestionOptionDBMock();
		IQuestionOption questionOption = QuestionAbstractFactory.instance().makeQuestionOption();
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		questionOptionDBMock.createOption(questionOption, 0);
		assertTrue(questionOption.getOptionTxt() == "intermediate");
		assertTrue(questionOption.getOptionScore() == "5");
	}
}