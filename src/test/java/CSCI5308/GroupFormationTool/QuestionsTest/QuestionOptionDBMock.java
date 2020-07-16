package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionOption;
import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;

public class QuestionOptionDBMock implements IQuestionOptionPersistence {

	@Override
	public boolean createOption(IQuestionOption questionOption, long questionID) {
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		return true;
	}
}