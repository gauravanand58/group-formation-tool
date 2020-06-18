package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Security.*;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionDB;
import CSCI5308.GroupFormationTool.Questions.ResponseDB;
import CSCI5308.GroupFormationTool.Questions.IQuestionManagerDB;
import CSCI5308.GroupFormationTool.Questions.QuestionManagerDB;

import CSCI5308.GroupFormationTool.Courses.*;

public class SystemConfig
{
	private static SystemConfig uniqueInstance = null;
	
	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IQuestionPersistence questionDB;
	private IResponsePersistence reponseDB;
	private IPasswordPolicyPersistance passwordPolicyDB;
	private IUserPasswordHistoryRelationshipPersistance userPasswordRelationshipDB;
	private IQuestionManagerDB questionManagerDB;

	
	// This private constructor ensures that no class other than System can allocate
	// the System object. The compiler would prevent it.
	private SystemConfig()
	{
		// The default instantiations are the choices that would be used in the
		// production application. These choices can all be overridden by test
		// setup logic when necessary.
		passwordEncryption = new BCryptPasswordEncryption();
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		questionDB = new QuestionDB();
		reponseDB = new ResponseDB();
		passwordPolicyDB = new PasswordPolicyDB();
		userPasswordRelationshipDB = new UserPasswordHistoryRelationshipDB();
		questionManagerDB = new QuestionManagerDB();
	}
	
	// This is the way the rest of the application gets access to the System object.
	public static SystemConfig instance()
	{
		// Using lazy initialization, this is the one and only place that the System
		// object will be instantiated.
		if (null == uniqueInstance)
		{
			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}
	
	public IPasswordEncryption getPasswordEncryption()
	{
		return passwordEncryption;
	}
	
	public void setPasswordEncryption(IPasswordEncryption passwordEncryption)
	{
		this.passwordEncryption = passwordEncryption;
	}
	
	public IUserPersistence getUserDB()
	{
		return userDB;
	}
	
	public void setUserDB(IUserPersistence userDB)
	{
		this.userDB = userDB;
	}
	
	public IDatabaseConfiguration getDatabaseConfiguration()
	{
		return databaseConfiguration;
	}
	
	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration)
	{
		this.databaseConfiguration = databaseConfiguration;
	}
	
	public void setCourseDB(ICoursePersistence courseDB)
	{
		this.courseDB = courseDB;
	}
	
	public ICoursePersistence getCourseDB()
	{
		return courseDB;
	}
	
	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB)
	{
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}
	
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

	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB()
	{
		return courseUserRelationshipDB;
	}

	public IQuestionPersistence getQuestionDB() {
		return questionDB;
	}

	public void setQuestionDB(IQuestionPersistence questionDB) {
		this.questionDB = questionDB;
	}

	public IResponsePersistence getReponseDB() {
		return reponseDB;
	}

	public void setReponseDB(IResponsePersistence reponseDB) {
		this.reponseDB = reponseDB;
	}

	public PasswordPolicyConfiguration getConfiguration() {
		return PasswordPolicyConfiguration.instance(passwordPolicyDB);
	}

	public IQuestionManagerDB getQuestionManagerDB() {
		return questionManagerDB;
	}

	public void setQuestionManagerDB(IQuestionManagerDB questionManagerDB) {
		this.questionManagerDB = questionManagerDB;
	}
}
