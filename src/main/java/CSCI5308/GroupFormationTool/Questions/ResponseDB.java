package CSCI5308.GroupFormationTool.Questions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class ResponseDB implements IResponsePersistence{

	@Override
	public List<Response> getAllResponsesOfQuestion(int questionID) {
		List<Response> responseList = new LinkedList<Response>();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spGetAllResponsesOfQuestion(?)");
			proc.setParameter(1, questionID);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					int responseID = results.getInt(1);
					String responseText = results.getString(2);
					Response response = new Response();
					response.setId(responseID);
					response.setResponseText(responseText);
					responseList.add(response);
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return responseList;
	}
}
