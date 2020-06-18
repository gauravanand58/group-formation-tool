package CSCI5308.GroupFormationTool.Questions;

import java.sql.SQLException;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionDB implements IQuestionPersistence{

	@Override
	public boolean deleteQuestion(int questionID) {
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spDeleteQuestion(?)");
			proc.setParameter(1, questionID);
			proc.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return true;
	}
	
}
