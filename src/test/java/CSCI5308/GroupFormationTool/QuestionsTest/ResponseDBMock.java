package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.Response;

public class ResponseDBMock implements IResponsePersistence{

	@Override
	public List<Response> getAllResponsesOfQuestion(int questionID) {
		List<Response> list = new LinkedList<Response>();
		list.add(new Response());
		return list;
	}
}
