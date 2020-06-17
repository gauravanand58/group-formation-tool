package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

public class QuestionManagerService implements IQuestionManagerService{
	@Override
	public List<Question> sortQues(String bannerID, String sortBy) {
		IQuestionManagerDB dao=new QuestionManagerDB();
		if(sortBy.equals("Title")) {
			return dao.sortByTitle(bannerID);
		}else if(sortBy.equals("Date")) {
			return dao.sortByDate(bannerID);
		}else {
			return null;
		}
	}

}
