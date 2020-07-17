package CSCI5308.GroupFormationTool.AccessControlTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IUserPasswordHistoryRelationshipPersistance;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordEncryptionMock;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyDBMock;
import CSCI5308.GroupFormationTool.SecurityTest.UserPasswordHistoryRelationshipDBMock;

public class UserTest {
	@Test
	public void ConstructorTests() {
		IUser u = UserAbstractFactory.instance().makeUser();
		assertTrue(u.getBannerID().isEmpty());
		assertTrue(u.getFirstName().isEmpty());
		assertTrue(u.getLastName().isEmpty());
		assertTrue(u.getEmail().isEmpty());

		IUserPersistence userDBMock = new UserDBMock();
		u = UserAbstractFactory.instance().makeUserWithID(1, userDBMock);
		assertTrue(u.getBannerID().equals("B00000000"));

		u = UserAbstractFactory.instance().makeUserWithBanner("B00000000", userDBMock);
		assertTrue(u.getBannerID().equals("B00000000"));
	}

	@Test
	public void setIDTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setID(10);
		assertTrue(10 == u.getID());
	}

	@Test
	public void getIDTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setID(10);
		assertTrue(10 == u.getID());
	}

	@Test
	public void setBannerIDTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setBannerID("B00000000");
		assertTrue(u.getBannerID().equals("B00000000"));
	}

	@Test
	public void getBannerIDTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setBannerID("B00000000");
		assertTrue(u.getBannerID().equals("B00000000"));
	}

	@Test
	public void setFirstNameTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setFirstName("Rob");
		assertTrue(u.getFirstName().equals("Rob"));
	}

	@Test
	public void getFirstNameTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setFirstName("Rob");
		assertTrue(u.getFirstName().equals("Rob"));
	}

	@Test
	public void setLastNameTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setLastName("Hawkey");
		assertTrue(u.getLastName().equals("Hawkey"));
	}

	@Test
	public void getLastNameTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setLastName("Hawkey");
		assertTrue(u.getLastName().equals("Hawkey"));
	}

	@Test
	public void setEmailTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setEmail("rhawkey@dal.ca");
		assertTrue(u.getEmail().equals("rhawkey@dal.ca"));
	}

	@Test
	public void getEmailTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setEmail("rhawkey@dal.ca");
		assertTrue(u.getEmail().equals("rhawkey@dal.ca"));
	}

	@Test
	public void createUser() {
		IUserPersistence userDB = new UserDBMock();
		IUser user = UserAbstractFactory.instance().makeUser();
		userDB.createUser(user);
		assertTrue(user.getId() == 0);
		assertTrue(user.getBannerID().equals("B00000000"));
	}

	@Test
	public void isBannerIDValidTest() {
		assertTrue(IUser.isBannerIDValid("B000000000"));
		assertTrue(!IUser.isBannerIDValid(null));
		assertTrue(!IUser.isBannerIDValid(""));
	}

	@Test
	public void isFirstNameValidTest() {
		assertTrue(IUser.isFirstNameValid("rob"));
		assertTrue(!IUser.isFirstNameValid(null));
		assertTrue(!IUser.isFirstNameValid(""));
	}

	@Test
	public void isLastNameValidTest() {
		assertTrue(IUser.isLastNameValid("hawkey"));
		assertTrue(!IUser.isLastNameValid(null));
		assertTrue(!IUser.isLastNameValid(""));
	}

	@Test
	public void isEmailValidTest() {
		assertTrue(IUser.isEmailValid("rhawkey@dal.ca"));
		assertTrue(!IUser.isEmailValid(null));
		assertTrue(!IUser.isEmailValid(""));
		assertTrue(!IUser.isEmailValid("@dal.ca"));
		assertTrue(!IUser.isEmailValid("rhawkey@"));
	}

	@Test
	public void isValidPasswordTest() {
		PasswordPolicyDBMock persistanceMock = new PasswordPolicyDBMock();
		PasswordPolicyConfiguration configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(IUser.isValidPassword("srIK2*", configuration));
		assertFalse(IUser.isValidPassword("sriK2*", configuration));
	}

	@Test
	public void saveUserPasswordHistoryTest() {
		IUser user = UserAbstractFactory.instance().makeUser();
		IUserPasswordHistoryRelationshipPersistance userPassRelationship = new UserPasswordHistoryRelationshipDBMock();
		user.saveUserPasswordHistory(userPassRelationship);
	}

	@Test
	public void validatePasswordHistoryTest() {
		IUser u = UserAbstractFactory.instance().makeUser();
		u.setID(1);
		PasswordPolicyDBMock persistanceMock = new PasswordPolicyDBMock();
		PasswordPolicyConfiguration configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		IUserPasswordHistoryRelationshipPersistance userPassRelationship = new UserPasswordHistoryRelationshipDBMock();
		IPasswordEncryption passwordEncryption = new PasswordEncryptionMock();
		assertTrue(u.validatePasswordHistory("", userPassRelationship, configuration, passwordEncryption));

		u.setID(2);
		assertFalse(u.validatePasswordHistory("encrypted", userPassRelationship, configuration, passwordEncryption));
	}
}
