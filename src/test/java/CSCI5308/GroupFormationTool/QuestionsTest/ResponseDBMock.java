package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class ResponseDBMock implements IQuestionResponsePersistence{

	@Override
	public List<QuestionResponse> getAllResponsesOfQuestion(int questionID) {
		List<QuestionResponse> list = new LinkedList<QuestionResponse>();
		list.add(new QuestionResponse());
		return list;
	}
}
