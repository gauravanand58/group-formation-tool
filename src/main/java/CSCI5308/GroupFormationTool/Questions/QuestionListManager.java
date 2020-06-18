package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public class QuestionListManager implements IQuestionListManager{
	@Override
	public List<Question> sortQuestions(String bannerID, String sortBy,IQuestionManagerDB questionManagerDB) {
		if(sortBy.equals("Title")) {
			return questionManagerDB.sortByTitle(bannerID);
		}else if(sortBy.equals("Date")) {
			return questionManagerDB.sortByDate(bannerID);
		}else {
			return null;
		}
	}

	@Override
	public List<Question> displayQuestions(String bannerID, IQuestionManagerDB questionManagerDB) {
		return questionManagerDB.displayQuestions(bannerID);
	}

}
