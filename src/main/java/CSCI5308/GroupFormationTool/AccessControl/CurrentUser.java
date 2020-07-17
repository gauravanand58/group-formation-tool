package CSCI5308.GroupFormationTool.AccessControl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {
	private static CurrentUser uniqueInstance = null;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private CurrentUser() {
	}

	public static CurrentUser instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new CurrentUser();
		}
		return uniqueInstance;
	}

	public IUser getCurrentAuthenticatedUser() {
		IUserPersistence userDB = UserSystemConfig.instance().getUserDB();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			String bannerID = authentication.getPrincipal().toString();
			IUser u = UserAbstractFactory.instance().makeUser();
			userDB.loadUserByBannerID(bannerID, u);
			if (u.isValidUser()) {
				logger.info("Valid User");
				return u;
			}
		}
		return null;
	}
}