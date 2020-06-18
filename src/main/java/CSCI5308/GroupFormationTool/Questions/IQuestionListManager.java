package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionListManager {
	public List<Question> sortQuestionsByTitle(String bannerID, IQuestionPersistence questionDB);
	public List<Question> sortQuestionsByDate(String bannerID, IQuestionPersistence questionDB);
	public List<Question> displayQuestions(String bannerID, IQuestionPersistence questionDB);
}
