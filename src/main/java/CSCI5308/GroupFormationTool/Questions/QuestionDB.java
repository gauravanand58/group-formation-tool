package CSCI5308.GroupFormationTool.Questions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionDB implements IQuestionPersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean deleteQuestion(int questionID) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDeleteQuestion(?)");
			proc.setParameter(1, questionID);
			proc.execute();
		} catch (SQLException e) {
			logger.error("spDeleteQuestion throws SQLException:"+e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Successfully deleted question of ID:"+questionID);
		return true;
	}

	@Override
	public long createQuestion(Question question) {
		CallStoredProcedure proc = null;
		long lastInsertedQuestion = -1;
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
			logger.error("spCreateQuestion throws SQLException:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return lastInsertedQuestion;
	}

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
					Question q = QuestionsSystemConfig.instance().getQuestion();
					q.setQuestionID(questionID);
					q.setQuestionTitle(questionTitle);
					q.setQuestionText(questionText);
					q.setQuestionType(questionType);
					q.setQuestionDateTime(questionDateTime);
					sortedQuestions.add(q);
				}
			}
		} catch (Exception e) {
			logger.error("spSortByTitle thows SQLExcpetion:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Successfully sorted by title");
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
					Question q = QuestionsSystemConfig.instance().getQuestion();
					q.setQuestionID(questionID);
					q.setQuestionTitle(questionTitle);
					q.setQuestionText(questionText);
					q.setQuestionType(questionType);
					q.setQuestionDateTime(questionDateTime);
					sortedQuestions.add(q);
				}
			}
		} catch (Exception e) {
			logger.error("spSortByDate throws SQLException:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Successfully sorted by date");
		return sortedQuestions;
	}

	@Override
	public List<Question> displayQuestions(String bannerID) {
		List<Question> displayQuestions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDisplayQuestions(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int questionID = results.getInt(1);
					String questionTitle = results.getString(2);
					String questionText = results.getString(3);
					String questionType = results.getString(4);
					String questionDateTime = results.getString(5);
					Question q = QuestionsSystemConfig.instance().getQuestion();
					q.setQuestionID(questionID);
					q.setQuestionTitle(questionTitle);
					q.setQuestionText(questionText);
					q.setQuestionType(questionType);
					q.setQuestionDateTime(questionDateTime);
					displayQuestions.add(q);
				}
			}
		} catch (Exception e) {
			logger.error("spDisplayQuestions throws SQLException:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return displayQuestions;
	}
}