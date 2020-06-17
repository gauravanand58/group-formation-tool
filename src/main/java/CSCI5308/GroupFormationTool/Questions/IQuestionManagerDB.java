package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionManagerDB {
	public List<Question> sortByTitle(String bannerID);
	public List<Question> sortByDate(String bannerID);
	public boolean createQuestion(Question question);
	public boolean createOption(QuestionOptions questionOptions);
	public List<Question> displayQues(String bannerID);
}
