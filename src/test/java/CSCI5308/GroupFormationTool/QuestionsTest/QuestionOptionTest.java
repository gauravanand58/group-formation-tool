package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

public class QuestionOptionTest {
	@Test
    void getOptionTxt() {
        QuestionOption questionOption = new QuestionOption();
        questionOption.setOptionTxt("a");
        assertSame("a",questionOption.getOptionTxt());
    }

	@Test
    void setOptionTxt() {
        QuestionOption questionOption=new QuestionOption();
        questionOption.setOptionTxt("a");
        assertSame("a",questionOption.getOptionTxt());
    }
	
	@Test
    void getOptionScore() {
        QuestionOption questionOption=new QuestionOption();
        questionOption.setOptionScore("1");
        assertSame("1",questionOption.getOptionScore());
    }

	@Test
    void setOptionScore() {
        QuestionOption questionOption=new QuestionOption();
        questionOption.setOptionScore("1");
        assertSame("1",questionOption.getOptionScore());
    }
	
	@Test
	public void createOptionTest() {
		IQuestionOptionPersistence questionOptionDBMock=new QuestionOptionDBMock();
		QuestionOption questionOption = new QuestionOption();
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		questionOptionDBMock.createOption(questionOption, 0);
		assertTrue(questionOption.getOptionTxt()=="intermediate");
		assertTrue(questionOption.getOptionScore()=="5");
	}
}
