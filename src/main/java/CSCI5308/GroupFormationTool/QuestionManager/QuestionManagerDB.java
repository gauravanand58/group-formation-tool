package CSCI5308.GroupFormationTool.QuestionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionManagerDB implements IQuestionManagerDB {
	private Long lastInsertedQuestion;

	@Override
	public List<Question> sortByTitle(String bannerID) {
		List<Question> sortedQues = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSortByTitle(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int quesID = results.getInt(1);
					String quesTitle = results.getString(2);
					String quesText = results.getString(3);
					String quesType = results.getString(4);
					String quesDateTime = results.getString(5);
					Question q = new Question();
					q.setQuesID(quesID);
					q.setQuesTitle(quesTitle);
					q.setQuesText(quesText);
					q.setQuesType(quesType);
					q.setQuesDateTime(quesDateTime);
					sortedQues.add(q);
				}
			}
		} catch (Exception e) {
			// handle exception
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return sortedQues;
	}

	@Override
	public List<Question> sortByDate(String bannerID) {

		List<Question> sortedQues = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSortByDate(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int quesID = results.getInt(1);
					String quesTitle = results.getString(2);
					String quesText = results.getString(3);
					String quesType = results.getString(4);
					String quesDateTime = results.getString(5);
					Question q = new Question();
					q.setQuesID(quesID);
					q.setQuesTitle(quesTitle);
					q.setQuesText(quesText);
					q.setQuesType(quesType);
					q.setQuesDateTime(quesDateTime);
					sortedQues.add(q);
				}
			}
		} catch (Exception e) {
			// handle exception
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return sortedQues;
	}

	@Override
	public List<Question> displayQues(String bannerID) {
		List<Question> displayQues=new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDisplayQuestions(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					int quesID = results.getInt(1);
					String quesTitle = results.getString(2);
					String quesText = results.getString(3);
					String quesType = results.getString(4);
					String quesDateTime = results.getString(5);
					Question q = new Question();
					q.setQuesID(quesID);
					q.setQuesTitle(quesTitle);
					q.setQuesText(quesText);
					q.setQuesType(quesType);
					q.setQuesDateTime(quesDateTime);
					displayQues.add(q);
				}
			}
		}catch (Exception e) {
			//handle exception
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return displayQues;
	}
	@Override
	public boolean createQuestion(Question question) {
		CallStoredProcedure proc = null;
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
			// Logging needed
			System.out.println("error" + e);
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;

	}
	@Override
	public boolean createOption(QuestionOptions questionOptions) {
		CallStoredProcedure proc = null;
		String[] optionTxt = questionOptions.getOptionTxt().split(",");
		String[] optionScore = questionOptions.getOptionScore().split(",");
		
		try {
			for (int i = 0; i < optionTxt.length; i++) {
				proc = new CallStoredProcedure("spCreateQuestionOption(?, ?, ?)");
				proc.setParameter(1, lastInsertedQuestion);
				proc.setParameter(2, optionTxt[i]);
				proc.setParameter(3, optionScore[i]);
				proc.execute();
			}

		} catch (SQLException e) {
			// Logging needed
			System.out.println("error" + e);
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;

	}
}
