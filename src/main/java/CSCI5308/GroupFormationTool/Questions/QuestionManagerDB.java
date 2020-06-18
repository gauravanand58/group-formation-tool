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
		List<Question> sortedQuestions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSortByTitle(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int questionID = results.getInt(1);
					String questionTitle = results.getString(2);
					String questionText = results.getString(3);
					String questionType = results.getString(4);
					String questionDateTime = results.getString(5);
					Question q = new Question();
					q.setQuestionID(questionID);
					q.setQuestionTitle(questionTitle);
					q.setQuestionText(questionText);
					q.setQuestionType(questionType);
					q.setQuestionDateTime(questionDateTime);
					sortedQuestions.add(q);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return sortedQuestions;
	}

	@Override
	public List<Question> sortByDate(String bannerID) {

		List<Question> sortedQuestions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSortByDate(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int questionID = results.getInt(1);
					String questionTitle = results.getString(2);
					String questionText = results.getString(3);
					String questionType = results.getString(4);
					String questionDateTime = results.getString(5);
					Question q = new Question();
					q.setQuestionID(questionID);
					q.setQuestionTitle(questionTitle);
					q.setQuestionText(questionText);
					q.setQuestionType(questionType);
					q.setQuestionDateTime(questionDateTime);
					sortedQuestions.add(q);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return sortedQuestions;
	}

	@Override
	public List<Question> displayQuestions(String bannerID) {
		List<Question> displayQuestions=new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDisplayQuestions(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					int questionID = results.getInt(1);
					String questionTitle = results.getString(2);
					String questionText = results.getString(3);
					String questionType = results.getString(4);
					String questionDateTime = results.getString(5);
					Question q = new Question();
					q.setQuestionID(questionID);
					q.setQuestionTitle(questionTitle);
					q.setQuestionText(questionText);
					q.setQuestionType(questionType);
					q.setQuestionDateTime(questionDateTime);
					displayQuestions.add(q);
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
		return displayQuestions;
	}
	@Override
	public boolean createQuestion(Question question) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spCreateQuestion(?, ?, ?, ?, ?)");
			proc.setParameter(1, question.getInstructorID());
			proc.setParameter(2, question.getQuestionTitle());
			proc.setParameter(3, question.getQuestionText());
			proc.setParameter(4, question.getQuestionType());
			proc.registerOutputParameterLong(5);
			proc.execute();
			lastInsertedQuestion = proc.getStatement().getLong(5);

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
