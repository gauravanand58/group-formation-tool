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
		System.out.println("delted: " + questionID);
		return true;
	}

	@Override
	public long createQuestion(Question question) {
		CallStoredProcedure proc = null;
		long lastInsertedQuestion = -1;
		try {
			proc = new CallStoredProcedure("spCreateQuestion(?, ?, ?, ?, ?)");
			proc.setParameter(1, question.getInstructorID());
			proc.setParameter(2, question.getQuesTitle());
			proc.setParameter(3, question.getQuesText());
			proc.setParameter(4, question.getQuesType());
			proc.registerOutputParameterLong(5);
			proc.execute();
			lastInsertedQuestion = proc.getStatement().getLong(5);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return lastInsertedQuestion;
	}
	
}
