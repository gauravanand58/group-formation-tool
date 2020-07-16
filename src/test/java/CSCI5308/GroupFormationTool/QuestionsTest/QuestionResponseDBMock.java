package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestionResponse;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;

public class QuestionResponseDBMock implements IQuestionResponsePersistence {

	@Override
	public List<IQuestionResponse> getAllResponsesOfQuestion(int questionID) {
		List<IQuestionResponse> list = new LinkedList<>();
		list.add(QuestionsSystemConfigTest.instance().getQuestionResponse());
		return list;
	}
}