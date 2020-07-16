package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.IQuestionListManager;
import CSCI5308.GroupFormationTool.Questions.IQuestionOption;
import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponse;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class QuestionFactoryMock extends QuestionAbstractFactory{

	@Override
	public IQuestionPersistence makeQuestionDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestionResponsePersistence makeReponseDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestionOptionPersistence makeQuestionOptionDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestionListManager makeQuestionListManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestion makeQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestionOption makeQuestionOption() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestion makeLoadedQuestion(IQuestionPersistence questionDB, long questionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestionResponse makeQuestionResponse() {
		// TODO Auto-generated method stub
		return null;
	}

}
