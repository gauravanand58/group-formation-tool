package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResponseDBMock implements IUserResponsePersistence {

	@Override
	public Map<Long, Map<Long, String>> loadUserResponsesForQuestions(long courseId) {
		Map<Long, Map<Long, String>> response = new HashMap<Long, Map<Long, String>>();
		Map<Long, String> questionMap = new HashMap<Long, String>();
		questionMap.put(11l, "Java");
		response.put(1l, questionMap);
		response.put(2l, questionMap);
		return response;
	}

	@Override
	public Map<Long, Map<Long, List<String>>> loadUserResponsesForMCQ2(long courseId) {
		Map<Long, Map<Long, List<String>>> response = new HashMap<Long, Map<Long, List<String>>>();
		Map<Long, List<String>> questionMap = new HashMap<Long, List<String>>();
		List<String> userResponse = new ArrayList<String>();
		userResponse.add("Java");
		userResponse.add("Python");
		questionMap.put(11l, userResponse);
		response.put(1l, questionMap);
		response.put(2l, questionMap);
		response.put(3l, questionMap);
		return response;
	}

}
