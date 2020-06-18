package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public class QuestionListManager implements IQuestionListManager{
	
	@Override
	public List<Question> sortQuestionsByTitle(String bannerID, IQuestionPersistence questionDB) {
		return questionDB.sortByDate(bannerID);
	}
	@Override
	public List<Question> sortQuestionsByDate(String bannerID, IQuestionPersistence questionDB) {
		return questionDB.sortByDate(bannerID);
	}

	@Override
	public List<Question> displayQuestions(String bannerID, IQuestionPersistence questionDB) {
		return questionDB.displayQuestions(bannerID);
	}
}
