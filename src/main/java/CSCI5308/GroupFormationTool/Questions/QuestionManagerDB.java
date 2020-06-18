package CSCI5308.GroupFormationTool.Questions;

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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
}
