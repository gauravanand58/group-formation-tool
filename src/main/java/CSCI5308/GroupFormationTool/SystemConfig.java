package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Security.*;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;
import CSCI5308.GroupFormationTool.Courses.*;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionDB;
import CSCI5308.GroupFormationTool.Questions.QuestionListManager;
import CSCI5308.GroupFormationTool.Questions.QuestionResponseDB;
import CSCI5308.GroupFormationTool.Questions.IQuestionListManager;
import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionOptionDB;

public class SystemConfig {
	private static SystemConfig uniqueInstance = null;

	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IQuestionPersistence questionDB;
	private IQuestionResponsePersistence reponseDB;
	private IPasswordPolicyPersistance passwordPolicyDB;
	private IUserPasswordHistoryRelationshipPersistance userPasswordRelationshipDB;
	private IQuestionOptionPersistence questionOptionDB;
	private IQuestionListManager questionListManager;

	private SystemConfig() {
		passwordEncryption = new BCryptPasswordEncryption();
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
//		courseDB = new CourseDB();
//		courseUserRelationshipDB = new CourseUserRelationshipDB();
		questionDB = new QuestionDB();
		reponseDB = new QuestionResponseDB();
		passwordPolicyDB = new PasswordPolicyDB();
		userPasswordRelationshipDB = new UserPasswordHistoryRelationshipDB();
		questionOptionDB = new QuestionOptionDB();
		questionListManager = new QuestionListManager();
	}

	public static SystemConfig instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}

	public IPasswordEncryption getPasswordEncryption() {
		return passwordEncryption;
	}

	public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
		this.passwordEncryption = passwordEncryption;
	}

	public IUserPersistence getUserDB() {
		return userDB;
	}

	public void setUserDB(IUserPersistence userDB) {
		this.userDB = userDB;
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}

//	public void setCourseDB(ICoursePersistence courseDB) {
//		this.courseDB = courseDB;
//	}
//
//	public ICoursePersistence getCourseDB() {
//		return courseDB;
//	}
//
//	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
//		this.courseUserRelationshipDB = courseUserRelationshipDB;
//	}

	public IPasswordPolicyPersistance getPasswordPolicyDB() {
		return passwordPolicyDB;
	}

	public void setPasswordPolicyDB(IPasswordPolicyPersistance passwordPolicyDB) {
		this.passwordPolicyDB = passwordPolicyDB;
	}

	public IUserPasswordHistoryRelationshipPersistance getUserPasswordRelationshipDB() {
		return userPasswordRelationshipDB;
	}

	public void setUserPasswordRelationshipDB(IUserPasswordHistoryRelationshipPersistance userPasswordRelationshipDB) {
		this.userPasswordRelationshipDB = userPasswordRelationshipDB;
	}

//	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
//		return courseUserRelationshipDB;
//	}

	public IQuestionPersistence getQuestionDB() {
		return questionDB;
	}

	public void setQuestionDB(IQuestionPersistence questionDB) {
		this.questionDB = questionDB;
	}

	public IQuestionResponsePersistence getReponseDB() {
		return reponseDB;
	}

	public void setReponseDB(IQuestionResponsePersistence reponseDB) {
		this.reponseDB = reponseDB;
	}

	public PasswordPolicyConfiguration getConfiguration() {
		return PasswordPolicyConfiguration.instance(passwordPolicyDB);
	}

	public IQuestionOptionPersistence getQuestionOptionDB() {
		return questionOptionDB;
	}

	public void setQuestionOptionDB(IQuestionOptionPersistence questionOptionDB) {
		this.questionOptionDB = questionOptionDB;
	}

	public IQuestionListManager getQuestionListManager() {
		return questionListManager;
	}

	public void setQuestionListManager(IQuestionListManager questionListManager) {
		this.questionListManager = questionListManager;
	}
}