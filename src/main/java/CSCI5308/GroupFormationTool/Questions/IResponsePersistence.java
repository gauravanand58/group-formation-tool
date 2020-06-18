package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IResponsePersistence {
	public List<Response> getAllResponsesOfQuestion(int questionID);
}
