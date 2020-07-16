package CSCI5308.GroupFormationTool.Algorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.GroupFormation.IGroupFormationRules;

class GroupFormationAlgorithm implements IGroupFormationAlgorithm {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	List<IGroupFormationRules> groupFormationRules;
	Map<Long, Map<Long, String>> userResponses;
	Map<Long, Map<Long, List<String>>> userMCQ2Responses;

	List<List<Long>> groupList;
	int maxGroupCount;
	Map<Long, Double> userScores;

	GroupFormationAlgorithm(List<IGroupFormationRules> groupFormationRules, Map<Long, Map<Long, String>> userResponses,
			Map<Long, Map<Long, List<String>>> userMCQ2Responses) {
		this.groupFormationRules = groupFormationRules;

		this.userResponses = new HashMap<Long, Map<Long, String>>(userResponses);
		this.userMCQ2Responses = new HashMap<Long, Map<Long, List<String>>>(userMCQ2Responses);

		this.maxGroupCount = this.groupFormationRules.get(0).getGroupSize();
		this.userScores = new HashMap<Long, Double>();

	}

	@Override
	public List<List<Long>> createGroups() {
		groupList = new LinkedList<List<Long>>();
		while (userResponses.size() + userMCQ2Responses.size() > 0) {
			calculateUserScoresForGroups();
		}
		logger.debug("Created Groups");
		return groupList;
	}

	private void calculateUserScoresForGroups() {
		userScores = new HashMap<Long, Double>();
		Long indexUser = 0l;
		if (userResponses.size() > 0) {
			indexUser = userResponses.keySet().stream().findFirst().get();
		} else if (userMCQ2Responses.size() > 0) {
			indexUser = userResponses.keySet().stream().findFirst().get();
		}

		if (indexUser != 0l) {
			Map<Long, String> indexUserResponse = userResponses.get(indexUser);

			for (IGroupFormationRules formationRules : groupFormationRules) {
				for (Long userID : userResponses.keySet()) {
					if (userID != indexUser) {
						String indexUserQuesResponse = indexUserResponse.get(formationRules.getQuestionId());
						String nextUsersResponse = userResponses.get(userID).get(formationRules.getQuestionId());

						if (null != indexUserQuesResponse && null != nextUsersResponse) {
							Double score = userScores.getOrDefault(userID, 0.0);
							if (formationRules.getType().equals("similar")) {
								if (indexUserQuesResponse.equalsIgnoreCase(nextUsersResponse)) {
									score += 10.0;
								}

							} else if (formationRules.getType().equals("dissimilar")) {
								if (!indexUserQuesResponse.equalsIgnoreCase(nextUsersResponse)) {
									score += 10.0;
								}
							} else if (formationRules.getType().equals("greater")) {
								if (Integer.parseInt(nextUsersResponse.trim()) > formationRules.getValue()) {
									score += (10.0 * 2);
								}
							} else if (formationRules.getType().equals("lesser")) {
								if (Integer.parseInt(nextUsersResponse.trim()) < formationRules.getValue()) {
									score += (10.0 * 2);
								}
							}
							userScores.put(userID, score);
						}
					}

				}
			}

			Map<Long, List<String>> indexUserMCQ2Response = userMCQ2Responses.get(indexUser);

			for (IGroupFormationRules formationRules : groupFormationRules) {
				for (Long userID : userMCQ2Responses.keySet()) {
					if (userID != indexUser) {
						List<String> indexUserQuesResponse = indexUserMCQ2Response.get(formationRules.getQuestionId());
						List<String> nextUsersResponse = userMCQ2Responses.get(userID)
								.get(formationRules.getQuestionId());

						if (null != indexUserQuesResponse && null != nextUsersResponse) {
							Double point = 10.0 / userMCQ2Responses.size();
							Double score = userScores.getOrDefault(userID, 0.0);
							for (String response : indexUserQuesResponse) {
								if (formationRules.getType().equals("similar")) {
									if (nextUsersResponse.contains(response)) {
										score += point;

									}

								} else if (formationRules.getType().equals("dissimilar")) {
									if (!nextUsersResponse.contains(response)) {
										score += point;
									}
								}
							}
							userScores.put(userID, score);

						}
					}

				}
			}

			List<Long> currentGroup = new LinkedList<>();
			currentGroup.add(indexUser);
			if (userScores.size() > 0) {
				matchUsersToGroup(currentGroup);
			}
			this.groupList.add(currentGroup);

			for (Long userID : currentGroup) {
				userResponses.remove(userID);
				userMCQ2Responses.remove(userID);
			}
		}

	}

	private void matchUsersToGroup(List<Long> group) {
		List<Map.Entry<Long, Double>> list = new LinkedList<Map.Entry<Long, Double>>(userScores.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Long, Double>>() {
			public int compare(Map.Entry<Long, Double> o1, Map.Entry<Long, Double> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		if (maxGroupCount - 1 <= list.size()) {
			for (int i = 0; i < maxGroupCount - 1; i++) {
				if (null != list.get(i)) {
					group.add(list.get(i).getKey());
				}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (null != list.get(i)) {
					group.add(list.get(i).getKey());
				}
			}
		}

	}

}
