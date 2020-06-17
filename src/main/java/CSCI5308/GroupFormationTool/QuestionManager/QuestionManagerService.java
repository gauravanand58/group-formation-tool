package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

public class QuestionManagerService implements IQuestionManagerService{
	@Override
	public List<Question> sortQues(String bannerID, String sortBy,IQuestionManagerDB questionManagerDB) {
		if(sortBy.equals("Title")) {
			return questionManagerDB.sortByTitle(bannerID);
		}else if(sortBy.equals("Date")) {
			return questionManagerDB.sortByDate(bannerID);
		}else {
			return null;
		}
	}

	@Override
	public List<Question> displayQues(String bannerID, IQuestionManagerDB questionManagerDB) {
		return questionManagerDB.displayQues(bannerID);
	}

}
