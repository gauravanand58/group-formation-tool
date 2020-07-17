package CSCI5308.GroupFormationTool.Algorithm;

import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.GroupFormation.IGroupFormationRules;

public interface IGroupFormationAlgorithmBuilder {
	public void setGroupFormationRules(List<IGroupFormationRules> groupFormationRules);

	public void setUserResponses(Map<Long, Map<Long, String>> userResponses);

	public void setUserMCQ2Responses(Map<Long, Map<Long, List<String>>> userMCQ2Responses);

	public IGroupFormationAlgorithm build();
}
