package CSCI5308.GroupFormationTool.GroupFormation;

import CSCI5308.GroupFormationTool.Algorithm.GroupFormationAlgorithmBuilder;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithmBuilder;

public class GroupFormationSystemConfigPersistance {
	private static GroupFormationSystemConfigPersistance uniqueInstance = null;
	
	IGroupFormationRulesPersistence formationRulesPersistence;
	IUserResponsePersistence userResponsePersistence;
	IGroupingService groupingService;
	IGroupFormationAlgorithmBuilder groupingAlgorithmBuilder;
	
	private GroupFormationSystemConfigPersistance() {
		formationRulesPersistence = new GroupFormationRulesDB();
		userResponsePersistence = new UserResponseDB();
		groupingService = new GroupingService();
		groupingAlgorithmBuilder = new GroupFormationAlgorithmBuilder();
	}
	
	public static GroupFormationSystemConfigPersistance instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new GroupFormationSystemConfigPersistance();
		}
		return uniqueInstance;
	}

	public IGroupFormationRulesPersistence getFormationRulesPersistence() {
		return formationRulesPersistence;
	}

	public IUserResponsePersistence getUserResponsePersistence() {
		return userResponsePersistence;
	}

	public IGroupingService getGroupingService() {
		return groupingService;
	}

	public IGroupFormationAlgorithmBuilder getGroupingAlgorithmBuilder() {
		return groupingAlgorithmBuilder;
	}


}
