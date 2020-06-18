package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionListManager {
	public List<Question> sortQuestions(String bannerID,String sortBy,IQuestionPersistence questionDB);
	public List<Question> displayQuestions(String bannerID, IQuestionPersistence questionDB);
}
