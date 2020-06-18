package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.Question;

public class QuestionDBMock implements IQuestionPersistence{

	@Override
	public boolean deleteQuestion(int questionID) {
		if(questionID == -1) {
			return true;
		}
		return false;
	}

	@Override
	public long createQuestion(Question question) {
		question.setInstructorID(1);
		question.setQuesID(1);
		question.setQuesTitle("Java");
		question.setQuesText("How familiar wih java?");
		question.setQuesDateTime("2020-06-10 00:00:00");
		return question.getQuesID();
	}
	
}
