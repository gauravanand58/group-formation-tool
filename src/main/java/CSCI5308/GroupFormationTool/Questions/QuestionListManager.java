package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionListManager implements IQuestionListManager{
	private static final String Title="Title";
	private static final String Date="Date";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<Question> displayQuestions(String bannerID, IQuestionPersistence questionDB) {
		return questionDB.displayQuestions(bannerID);
	}

	@Override
	public List<Question> sortQuestions(String bannerID, String sortBy,IQuestionPersistence questionDB) {
		if(sortBy.equals(Title)) {
			logger.info("Sorting questions by Title");
			return questionDB.sortByTitle(bannerID);
		}else if(sortBy.equals(Date)) {
			logger.info("Sorting questions by Date");
			return questionDB.sortByDate(bannerID);
		}else {
			logger.error("String sortBy is not equal to 'Title'/'Date'");
			return null;
		}
	}
}