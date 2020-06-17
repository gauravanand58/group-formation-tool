package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

public interface IQuestionManagerService {
	public List<Question> sortQues(String bannerID,String sortBy,IQuestionManagerDB questionManagerDB);
	public List<Question> displayQues(String bannerID,IQuestionManagerDB questionManagerDB);
}
