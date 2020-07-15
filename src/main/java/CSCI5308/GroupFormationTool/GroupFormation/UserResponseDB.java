package CSCI5308.GroupFormationTool.GroupFormation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class UserResponseDB implements IUserResponsePersistence {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Map<Long, Map<Long, String>> loadUserResponsesForQuestions(long courseId) {
		Map<Long, Map<Long, String>> userResponses = new HashMap<Long, Map<Long,String>>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadUserResponses(?)");
			proc.setParameter(1, courseId);
			
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userId = results.getLong(1);
					long questionId = results.getLong(2);
					String response = results.getString(3);
					if (null != userResponses.get(userId)) {
						userResponses.get(userId).put(questionId, response);
					} else {
						Map<Long, String> question = new HashMap<>();
						question.put(questionId, response);
						userResponses.put(userId, question);
					}
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadUserResponses() throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return userResponses;
	}
	

	@Override
	public Map<Long, Map<Long, List<String>>> loadUserResponsesForMCQ2(long courseId) {
		Map<Long, Map<Long, List<String>>> userResponses = new HashMap<Long, Map<Long,List<String>>>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadUserResponsesMCQ2(?)");
			proc.setParameter(1, courseId);
			
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {	
				long userId = results.getLong(1);
				long questionId = results.getLong(2);
				String response = results.getString(3);
				if (null != userResponses.get(userId)) {
					if (null != userResponses.get(userId).get(questionId)) {
						userResponses.get(userId).get(questionId).add(response);
					} else {
						List<String> responses = new ArrayList<>();
						responses.add(response);
						userResponses.get(userId).put(questionId, responses);
					}
				} else {
					List<String> responses = new ArrayList<>();
					responses.add(response);
					Map<Long, List<String>> question = new HashMap<>();
					question.put(questionId, responses);
					userResponses.put(userId, question);
				}
				}
			}
			
		} catch (SQLException e) {
			logger.error("spLoadUserResponsesMCQ2() throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return userResponses;
	}
	
	

}
