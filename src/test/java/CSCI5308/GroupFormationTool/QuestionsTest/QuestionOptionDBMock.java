package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;

public class QuestionOptionDBMock implements IQuestionOptionPersistence{

	@Override
	public boolean createOption(QuestionOption questionOption, long questionID) {
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		return true;
	}
}
