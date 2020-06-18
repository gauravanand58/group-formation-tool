package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;

public class QuestionDBMock implements IQuestionPersistence{

	@Override
	public boolean deleteQuestion(int questionID) {
		if(questionID == -1) {
			return true;
		}
		return false;
	}
	
}
