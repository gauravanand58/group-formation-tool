package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionResponsePersistence {
	public List<IQuestionResponse> getAllResponsesOfQuestion(int questionID);
}