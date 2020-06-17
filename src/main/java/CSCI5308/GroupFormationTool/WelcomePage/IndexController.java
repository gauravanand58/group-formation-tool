package CSCI5308.GroupFormationTool.WelcomePage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.Courses.*;

@Controller
public class IndexController
{
	@GetMapping("/")
	public String greeting(Model model, HttpServletRequest httpServletRequest)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated())
		{
			ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
			List<Course> allCourses = courseDB.loadAllCourses();
			model.addAttribute("courses", allCourses);
			IUserPersistence userDb = SystemConfig.instance().getUserDB();
			Long isUserInstructor = userDb.checkUserByBannerID(httpServletRequest.getRemoteUser());
			if(isUserInstructor == 0) 
			{
				model.addAttribute("QuestionSet", "hidden");
				
			}
			else 
			{
				model.addAttribute("QuestionSet", "visible");
				model.addAttribute("isUserInstructor", isUserInstructor);
			}
		}
		return "index";
	}
}