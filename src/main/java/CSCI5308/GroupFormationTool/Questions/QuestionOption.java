package CSCI5308.GroupFormationTool.Questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionOption {
	private int optionId;
	private String optionTxt;
	private String optionScore;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String getOptionTxt() {
		return optionTxt;
	}

	public void setOptionTxt(String optionTxt) {
		this.optionTxt = optionTxt;
	}

	public String getOptionScore() {
		return optionScore;
	}

	public void setOptionScore(String optionScore) {
		this.optionScore = optionScore;
	}

	public boolean createOption(IQuestionOptionPersistence questionOptionDB, long questionID) {
		logger.info("Calling createOption with quesID:" + questionID);
		return questionOptionDB.createOption(this, questionID);
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

}