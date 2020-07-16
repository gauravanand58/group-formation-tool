package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionPersistence {
	public long createQuestion(IQuestion question);

	public boolean deleteQuestion(int questionID);

	public List<IQuestion> sortByTitle(String bannerID);

	public List<IQuestion> sortByDate(String bannerID);

	public List<IQuestion> displayQuestions(String bannerID);

	public void loadQuestionByID(IQuestion question, long questionID);
}
