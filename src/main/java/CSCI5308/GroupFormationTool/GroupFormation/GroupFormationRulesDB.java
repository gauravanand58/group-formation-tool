package CSCI5308.GroupFormationTool.GroupFormation;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class GroupFormationRulesDB implements IGroupFormationRulesPersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean createGroupFormationRules(GroupFormationRules formationRules) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spCreateForSurveyRules(?,?,?,?,?)");
			proc.setParameter(1, formationRules.getCourseId());
			proc.setParameter(2, formationRules.getQuestionId());
			proc.setParameter(3, formationRules.getType());
			proc.setParameter(4, formationRules.getValue());
			proc.setParameter(5, formationRules.getGroupSize());
			proc.execute();
		} catch (SQLException e) {
			logger.error("spCreateForSurveyRules() throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}
}
