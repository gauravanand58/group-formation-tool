package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.QuestionOptions;

public class QuestionOptionsMock {
	@Test
    void getOptionTxt() {
        QuestionOptions questionModel=new QuestionOptions();
        questionModel.setOptionTxt("a");
        assertSame("a",questionModel.getOptionTxt());
    }

	@Test
    void setOptionTxt() {
        QuestionOptions questionModel=new QuestionOptions();
        questionModel.setOptionTxt("a");
        assertSame("a",questionModel.getOptionTxt());
    }
	
	@Test
    void getOptionScore() {
        QuestionOptions questionModel=new QuestionOptions();
        questionModel.setOptionScore("1");
        assertSame("1",questionModel.getOptionScore());
    }

	@Test
    void setOptionScore() {
        QuestionOptions questionModel=new QuestionOptions();
        questionModel.setOptionScore("1");
        assertSame("1",questionModel.getOptionScore());
    }

}
