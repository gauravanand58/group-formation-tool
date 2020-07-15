package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionListManager {
	public List<IQuestion> sortQuestions(String bannerID,String sortBy,IQuestionPersistence questionDB);

	public List<IQuestion> displayQuestions(String bannerID, IQuestionPersistence questionDB);
}
