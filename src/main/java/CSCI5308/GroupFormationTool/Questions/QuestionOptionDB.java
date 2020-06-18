package CSCI5308.GroupFormationTool.Questions;

import java.sql.SQLException;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionOptionDB implements IQuestionOptionPersistence{

	@Override
	public boolean createOption(QuestionOption questionOptions, long questionID) {
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
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}
}
