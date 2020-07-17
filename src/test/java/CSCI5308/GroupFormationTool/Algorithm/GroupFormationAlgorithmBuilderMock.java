package CSCI5308.GroupFormationTool.Algorithm;

import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.GroupFormation.IGroupFormationRules;

public class GroupFormationAlgorithmBuilderMock implements IGroupFormationAlgorithmBuilder {
	List<IGroupFormationRules> groupFormationRules;

	Map<Long, Map<Long, String>> userResponses;
	Map<Long, Map<Long, List<String>>> userMCQ2Responses;

	public void setGroupFormationRules(List<IGroupFormationRules> groupFormationRules) {
		this.groupFormationRules = groupFormationRules;
	}

	public void setUserResponses(Map<Long, Map<Long, String>> userResponses) {
		this.userResponses = userResponses;
	}

	public void setUserMCQ2Responses(Map<Long, Map<Long, List<String>>> userMCQ2Responses) {
		this.userMCQ2Responses = userMCQ2Responses;
	}

	@Override
	public IGroupFormationAlgorithm build() {
		return new GroupFormationAlgorithmMock();
	}
}
