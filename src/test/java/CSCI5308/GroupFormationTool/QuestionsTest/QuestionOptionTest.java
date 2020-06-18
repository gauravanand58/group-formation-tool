package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestionManagerDB;
import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

public class QuestionOptionTest {
	@Test
    void getOptionTxt() {
        QuestionOption questionModel=new QuestionOption();
        questionModel.setOptionTxt("a");
        assertSame("a",questionModel.getOptionTxt());
    }

	@Test
    void setOptionTxt() {
        QuestionOption questionModel=new QuestionOption();
        questionModel.setOptionTxt("a");
        assertSame("a",questionModel.getOptionTxt());
    }
	
	@Test
    void getOptionScore() {
        QuestionOption questionModel=new QuestionOption();
        questionModel.setOptionScore("1");
        assertSame("1",questionModel.getOptionScore());
    }

	@Test
    void setOptionScore() {
        QuestionOption questionModel=new QuestionOption();
        questionModel.setOptionScore("1");
        assertSame("1",questionModel.getOptionScore());
    }
	
	@Test
	public void createOptionTest() {
		IQuestionOptionPersistence dao=new QuestionOptionDBMock();
		QuestionOption questionOption = new QuestionOption();
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		dao.createOption(questionOption, 0);
		assertTrue(questionOption.getOptionTxt()=="intermediate");
		assertTrue(questionOption.getOptionScore()=="5");
	}
}
