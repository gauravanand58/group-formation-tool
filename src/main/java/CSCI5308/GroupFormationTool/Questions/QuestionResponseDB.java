package CSCI5308.GroupFormationTool.Questions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionResponseDB implements IQuestionResponsePersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<QuestionResponse> getAllResponsesOfQuestion(int questionID) {
		List<QuestionResponse> responseList = new LinkedList<QuestionResponse>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spGetAllResponsesOfQuestion(?)");
			proc.setParameter(1, questionID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int responseID = results.getInt(1);
					String responseText = results.getString(2);
					QuestionResponse response = QuestionsSystemConfig.instance().getQuestionResponse();
					response.setId(responseID);
					response.setResponseText(responseText);
					responseList.add(response);
				}
			}
		} catch (SQLException e) {
			logger.error("spGetAllResponsesOfQuestion throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return responseList;
	}
}