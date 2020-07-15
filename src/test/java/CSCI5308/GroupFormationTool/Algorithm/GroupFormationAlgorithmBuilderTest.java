package CSCI5308.GroupFormationTool.Algorithm;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupFormation.GroupFormationRules;
import CSCI5308.GroupFormationTool.GroupFormation.IGroupFormationRules;
import CSCI5308.GroupFormationTool.GroupFormation.IUserResponsePersistence;
import CSCI5308.GroupFormationTool.GroupFormation.UserResponseDBMock;

public class GroupFormationAlgorithmBuilderTest {

	@Test
	public void setGroupFormationRulesTest() {
		GroupFormationAlgorithmBuilder algorithmBuilder = new GroupFormationAlgorithmBuilder();
		List<IGroupFormationRules> groupingRules= new ArrayList<IGroupFormationRules>();
		IGroupFormationRules formationRules = new GroupFormationRules();
		
		formationRules.setGroupSize(2);
		formationRules.setQuestionId(2l);
		formationRules.setSurveyId(1l);
		formationRules.setType("similar");
		formationRules.setValue(0);
		groupingRules.add(formationRules);
		
		algorithmBuilder.setGroupFormationRules(groupingRules);
		assertNotNull(algorithmBuilder.groupFormationRules);
	}
	
	@Test
	public void setUserResponsesTest() {
		GroupFormationAlgorithmBuilder algorithmBuilder = new GroupFormationAlgorithmBuilder();
		IUserResponsePersistence userMockDB = new UserResponseDBMock();
		algorithmBuilder.userResponses = userMockDB.loadUserResponsesForQuestions(1l);
		
		assertTrue(algorithmBuilder.userResponses.size()>0);
	}

	@Test
	public void setUserMCQ2ResponsesTest() {
		GroupFormationAlgorithmBuilder algorithmBuilder = new GroupFormationAlgorithmBuilder();
		IUserResponsePersistence userMockDB = new UserResponseDBMock();
		algorithmBuilder.userMCQ2Responses = userMockDB.loadUserResponsesForMCQ2(1l);
		
		
		assertTrue(algorithmBuilder.userMCQ2Responses.size()>0);
	}

	@Test
	public void buildTest() {
		IGroupFormationAlgorithmBuilder algorithmBuilder = new GroupFormationAlgorithmBuilderMock();
		List<IGroupFormationRules> groupingRules= new ArrayList<IGroupFormationRules>();
		IGroupFormationRules formationRules = new GroupFormationRules();
		
		formationRules.setGroupSize(2);
		formationRules.setQuestionId(2l);
		formationRules.setSurveyId(1l);
		formationRules.setType("similar");
		formationRules.setValue(0);
		groupingRules.add(formationRules);
		
		algorithmBuilder.setGroupFormationRules(groupingRules);
		IUserResponsePersistence userMockDB = new UserResponseDBMock();
		algorithmBuilder.setUserMCQ2Responses(userMockDB.loadUserResponsesForMCQ2(1l));
		algorithmBuilder.setUserResponses(userMockDB.loadUserResponsesForQuestions(1l));
		IGroupFormationAlgorithm algorithm = algorithmBuilder.build();
		assertNotNull(algorithm);
		
	}
}
