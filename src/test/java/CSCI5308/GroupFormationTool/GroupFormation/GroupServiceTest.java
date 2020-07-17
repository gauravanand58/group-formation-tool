package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Algorithm.GroupFormationAlgorithmBuilderMock;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithmBuilder;

public class GroupServiceTest {

	@Test
	public void createGroupsTests() {
		IGroupingService groupingService = new GroupingService();
		List<IGroupFormationRules> groupingRules = new ArrayList<IGroupFormationRules>();
		IGroupFormationRules formationRules = new GroupFormationRules();

		formationRules.setGroupSize(2);
		formationRules.setQuestionId(2l);
		formationRules.setCourseId(1l);
		formationRules.setType("similar");
		formationRules.setValue(0);
		groupingRules.add(formationRules);
		IUserResponsePersistence userResponsePersistence = new UserResponseDBMock();
		IGroupFormationAlgorithmBuilder groupingAlgorithmBuilder = new GroupFormationAlgorithmBuilderMock();
		long courseID = 3l;
		groupingService.createGroups(groupingRules, userResponsePersistence, groupingAlgorithmBuilder, courseID);
	}
}
