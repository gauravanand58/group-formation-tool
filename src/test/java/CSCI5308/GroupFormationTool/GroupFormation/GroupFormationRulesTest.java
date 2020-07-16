package CSCI5308.GroupFormationTool.GroupFormation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GroupFormationRulesTest {
	@Test
	public void ConstructorTests() {
		IGroupFormationRulesPersistence groupPolicyDB = new GroupFormationRulesPersistenceMock();
		IGroupFormationRules rules = new GroupFormationRules(1l, 2l, "similar", 0, 2, groupPolicyDB);

		assertTrue(rules.getType().equals("similar"));
		assertTrue(rules.getQuestionId() == 2l);
		assertTrue(rules.getGroupSize() == 2);
		assertTrue(rules.getValue() == 0);

	}

	@Test
	public void getSurveyIdTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setCourseId(1l);
		assertTrue(rules.getCourseId() == 1l);
	}

	@Test
	public void setSurveyIdTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setCourseId(1l);
		assertTrue(rules.getCourseId() == 1l);
	}

	@Test
	public void getQuestionIdTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setQuestionId(1l);
		assertTrue(rules.getQuestionId() == 1l);
	}

	@Test
	public void setQuestionIdTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setQuestionId(1l);
		assertTrue(rules.getQuestionId() == 1l);
	}

	@Test
	public void getTypeTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setType("similar");
		assertTrue(rules.getType().equals("similar"));
	}

	@Test
	public void setTypeTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setType("similar");
		assertTrue(rules.getType().equals("similar"));
	}

	@Test
	public void getValueTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setValue(1);
		assertTrue(rules.getValue() == 1);
	}

	@Test
	public void setValueTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setValue(1);
		assertTrue(rules.getValue() == 1);
	}

	@Test
	public void getGroupSizeTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setGroupSize(1);
		assertTrue(rules.getGroupSize() == 1);
	}

	@Test
	public void setGroupSizeTest() {
		IGroupFormationRules rules = new GroupFormationRules();
		rules.setGroupSize(1);
		assertTrue(rules.getGroupSize() == 1);
	}

}
