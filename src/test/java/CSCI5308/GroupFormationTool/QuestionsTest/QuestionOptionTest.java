package CSCI5308.GroupFormationTool.QuestionsTest;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

@SuppressWarnings("deprecation")
public class QuestionOptionTest {
	@Test
    void getOptionTxt() {
        QuestionOption questionOption = new QuestionOption();
        questionOption.setOptionTxt("a");
        Assert.isTrue(questionOption.getOptionTxt().equals("a"));
    }

	@Test
    void setOptionTxt() {
        QuestionOption questionOption=new QuestionOption();
        questionOption.setOptionTxt("a");
        Assert.isTrue(questionOption.getOptionTxt().equals("a"));
    }
	
	@Test
    void getOptionScore() {
        QuestionOption questionOption=new QuestionOption();
        questionOption.setOptionScore("1");
        Assert.isTrue(questionOption.getOptionScore().equals("1"));
    }

	@Test
    void setOptionScore() {
        QuestionOption questionOption=new QuestionOption();
        questionOption.setOptionScore("1");
        Assert.isTrue(questionOption.getOptionScore().equals("1"));
	}
	
	@Test
	public void createOptionTest() {
		IQuestionOptionPersistence questionOptionDBMock=new QuestionOptionDBMock();
		QuestionOption questionOption = new QuestionOption();
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		questionOptionDBMock.createOption(questionOption, 0);
		Assert.isTrue(questionOption.getOptionTxt()=="intermediate");
		Assert.isTrue(questionOption.getOptionScore()=="5");
	}
}
