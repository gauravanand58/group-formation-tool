package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithmBuilder;

public interface IGroupingService {
	public Map<Integer, Map<User, List<String>>> createGroups(List<IGroupFormationRules> groupingRules,
			IUserResponsePersistence userResponsePersistence, IGroupFormationAlgorithmBuilder algorithmBuilder,
			long courseId);
}
