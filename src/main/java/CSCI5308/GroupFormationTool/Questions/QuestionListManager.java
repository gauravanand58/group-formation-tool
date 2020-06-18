package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public class QuestionListManager implements IQuestionListManager{
	private static final String Title="Title";
	private static final String Date="Date";

	@Override
	public List<Question> displayQuestions(String bannerID, IQuestionPersistence questionDB) {
		return questionDB.displayQuestions(bannerID);
	}

	@Override
	public List<Question> sortQuestions(String bannerID, String sortBy,IQuestionPersistence questionDB) {
		if(sortBy.equals(Title)) {
			return questionDB.sortByTitle(bannerID);
		}else if(sortBy.equals(Date)) {
			return questionDB.sortByDate(bannerID);
		}else {
			return null;
		}
	}
}