package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserDB;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithm;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithmBuilder;

public class GroupingService implements IGroupingService {

	@Override
	public Map<Integer, Map<User, List<String>>> createGroups(List<IGroupFormationRules> groupingRules,IUserResponsePersistence userResponsePersistence, IGroupFormationAlgorithmBuilder algorithmBuilder ) {
	

		Map<Long, Map<Long, String>> userResponses = new HashMap<Long, Map<Long, String>>();
		// to be replaced with courseId
		userResponses = userResponsePersistence.loadUserResponsesForQuestions(3l);

		Map<Long, Map<Long, List<String>>> userMCQ2Responses = new HashMap<Long, Map<Long, List<String>>>();
		userMCQ2Responses = userResponsePersistence.loadUserResponsesForMCQ2(3l);

		algorithmBuilder.setGroupFormationRules(groupingRules);
		algorithmBuilder.setUserResponses(userResponses);
		algorithmBuilder.setUserMCQ2Responses(userMCQ2Responses);

		System.out.print(userResponses.get(1l).get(30l));

		System.out.print(userMCQ2Responses.get(1l).get(27l));

		IGroupFormationAlgorithm groupingAlgorithm = algorithmBuilder.build();
		List<List<Long>> groupList = groupingAlgorithm.createGroups();

		return generateUserGroups(groupList,userResponses,userMCQ2Responses);
	}
	
	Map<Integer, Map<User, List<String>>> generateUserGroups(List<List<Long>> groupList
			, Map<Long, Map<Long, String>> userResponses, Map<Long, Map<Long, List<String>>> userMCQ2Responses){

		Map<Integer, Map<User, List<String>>> response = new HashMap<Integer, Map<User, List<String>>>();

		int groupNumber = 0;

		for (List<Long> group : groupList) {
			IUserPersistence persistence = new UserDB();
			Map<User, List<String>> userAllResponses = new HashMap<User, List<String>>();
			for (Long userId : group) {
				User user = new User();
				persistence.loadUserByID(userId, user);
				System.out.print("group:" + groupNumber);
				System.out.print("LastName:" + user.getLastName() + ", FirstName:" + user.getFirstName() + ", Quest:");
				List<String> allResponses = new ArrayList<String>();
				if (null != userResponses.get(userId)) {
					for (Long questionId : userResponses.get(userId).keySet()) {
						if (null != userResponses.get(userId).get(questionId)) {
							allResponses.add(userResponses.get(userId).get(questionId));

							System.out.print(userResponses.get(userId).get(questionId) + ", ");
						}
					}
				}
				if (null != userMCQ2Responses.get(userId)) {
					for (Long questionId : userMCQ2Responses.get(userId).keySet()) {
						if (null != userMCQ2Responses.get(userId).get(questionId)) {
							String multiResponse = "";
							for(String multipleResponse: userMCQ2Responses.get(userId).get(questionId)) {
								if(multiResponse!="") {
									multiResponse =multiResponse + ", ";
								}	
								multiResponse = multiResponse + multipleResponse;
							}
							
							allResponses.add(multiResponse);
							System.out.print(userMCQ2Responses.get(userId).get(questionId) + ", ");
						}
					}
				}
				userAllResponses.put(user, allResponses);
				System.out.println();
			}

			groupNumber += 1;
			response.put(groupNumber, userAllResponses);
		}
		return response;
	}

}
