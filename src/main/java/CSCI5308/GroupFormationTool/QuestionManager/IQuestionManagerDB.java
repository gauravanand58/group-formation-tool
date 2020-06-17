package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

public interface IQuestionManagerDB {
	public List<Question> sortByTitle(String bannerID);
	public List<Question> sortByDate(String bannerID);
	public List<Question> displayQues(String bannerID);
}
