package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestionResponse;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class QuestionResponseDBMock implements IQuestionResponsePersistence {

	@Override
	public List<IQuestionResponse> getAllResponsesOfQuestion(int questionID) {
		List<IQuestionResponse> list = new LinkedList<>();
		list.add(QuestionAbstractFactory.instance().makeQuestionResponse());
		return list;
	}
}