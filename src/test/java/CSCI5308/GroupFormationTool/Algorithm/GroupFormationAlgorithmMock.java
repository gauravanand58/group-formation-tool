package CSCI5308.GroupFormationTool.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class GroupFormationAlgorithmMock implements IGroupFormationAlgorithm {

	@Override
	public List<List<Long>> createGroups() {
		List<List<Long>> userGroups = new ArrayList<List<Long>>();
		List<Long> groups = new ArrayList<Long>();
		groups.add(1l);
		groups.add(2l);
		groups.add(3l);
		userGroups.add(groups);
		return userGroups;
	}

}
