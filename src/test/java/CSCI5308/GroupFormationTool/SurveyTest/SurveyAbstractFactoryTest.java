package CSCI5308.GroupFormationTool.SurveyTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;

public class SurveyAbstractFactoryTest {
	
	@Test
	public void instanceTest() {
		SurveyAbstractFactory instance = SurveyAbstractFactory.instance();
		assertTrue(null != instance);
	}
	
	@Test
	public void setFactoryTest() {
		SurveyAbstractFactory instance = SurveyAbstractFactory.instance();
		instance.setFactory(SurveyTestSystemConfig.instance().getSurveyFactoryMock());
		assertTrue(instance.getFactory() instanceof SurveyFactoryMock);
		instance.setFactory(new SurveyFactory());
	}
}
