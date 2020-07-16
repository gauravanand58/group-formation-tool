package CSCI5308.GroupFormationTool.Questions;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionOptionDB implements IQuestionOptionPersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean createOption(IQuestionOption questionOptions, long questionID) {
		CallStoredProcedure proc = null;
		String[] optionTxt = questionOptions.getOptionTxt().split(",");
		String[] optionScore = questionOptions.getOptionScore().split(",");

		try {
			for (int i = 0; i < optionTxt.length; i++) {
				proc = new CallStoredProcedure("spCreateQuestionOption(?, ?, ?)");
				proc.setParameter(1, questionID);
				proc.setParameter(2, optionTxt[i]);
				proc.setParameter(3, optionScore[i]);
				proc.execute();
			}
		} catch (SQLException e) {
			logger.error("spCreateQuestionOption throws SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Successfully created question options");
		return true;
	}
}