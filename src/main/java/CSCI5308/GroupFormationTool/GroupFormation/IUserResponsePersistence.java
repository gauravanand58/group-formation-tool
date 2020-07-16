package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.List;
import java.util.Map;

public interface IUserResponsePersistence {
	
	public Map<Long,Map<Long,String>> loadUserResponsesForQuestions(long courseId);
		
	public Map<Long, Map<Long, List<String>>> loadUserResponsesForMCQ2(long courseId);
	
}
