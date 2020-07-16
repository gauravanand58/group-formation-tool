package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import CSCI5308.GroupFormationTool.AccessControl.UserDB;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithm;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithmBuilder;

public class GroupingService implements IGroupingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<Integer, Map<IUser, List<String>>> createGroups(List<IGroupFormationRules> groupingRules,
			IUserResponsePersistence userResponsePersistence, IGroupFormationAlgorithmBuilder algorithmBuilder,
			long courseID) {

		Map<Long, Map<Long, String>> userResponses = new HashMap<Long, Map<Long, String>>();
		userResponses = userResponsePersistence.loadUserResponsesForQuestions(courseID);
		Map<Long, Map<Long, List<String>>> userMCQ2Responses = new HashMap<Long, Map<Long, List<String>>>();
		userMCQ2Responses = userResponsePersistence.loadUserResponsesForMCQ2(courseID);

		algorithmBuilder.setGroupFormationRules(groupingRules);
		algorithmBuilder.setUserResponses(userResponses);
		algorithmBuilder.setUserMCQ2Responses(userMCQ2Responses);

		IGroupFormationAlgorithm groupingAlgorithm = algorithmBuilder.build();
		List<List<Long>> groupList = groupingAlgorithm.createGroups();
		logger.debug("groups created: " + groupList.size());
		return generateUserGroups(groupList, userResponses, userMCQ2Responses);
	}

	private Map<Integer, Map<IUser, List<String>>> generateUserGroups(List<List<Long>> groupList,
			Map<Long, Map<Long, String>> userResponses, Map<Long, Map<Long, List<String>>> userMCQ2Responses) {

		Map<Integer, Map<IUser, List<String>>> response = new HashMap<Integer, Map<IUser, List<String>>>();
		int groupNumber = 0;
		for (List<Long> group : groupList) {
			IUserPersistence persistence = UserAbstractFactory.instance().makeUserDB();
			Map<IUser, List<String>> userAllResponses = new HashMap<IUser, List<String>>();
			for (Long userId : group) {
				IUser user = UserAbstractFactory.instance().makeUser();
				persistence.loadUserByID(userId, user);
				List<String> allResponses = new ArrayList<String>();
				if (null != userResponses.get(userId)) {
					for (Long questionId : userResponses.get(userId).keySet()) {
						if (null != userResponses.get(userId).get(questionId)) {
							allResponses.add(userResponses.get(userId).get(questionId));
						}
					}
				}
				if (null != userMCQ2Responses.get(userId)) {
					for (Long questionId : userMCQ2Responses.get(userId).keySet()) {
						if (null != userMCQ2Responses.get(userId).get(questionId)) {
							String multiResponse = "";
							for (String multipleResponse : userMCQ2Responses.get(userId).get(questionId)) {
								if (multiResponse != "") {
									multiResponse = multiResponse + ", ";
								}
								multiResponse = multiResponse + multipleResponse;
							}

							allResponses.add(multiResponse);
						}
					}
				}
				userAllResponses.put(user, allResponses);
			}

			groupNumber += 1;
			response.put(groupNumber, userAllResponses);
		}
		return response;
	}
}
