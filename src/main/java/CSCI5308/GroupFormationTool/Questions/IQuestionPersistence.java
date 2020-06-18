package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionPersistence {
	public long createQuestion(Question question);
	public boolean deleteQuestion(int questionID);
	public List<Question> sortByTitle(String bannerID);
	public List<Question> sortByDate(String bannerID);
	public List<Question> displayQuestions(String bannerID);
}
