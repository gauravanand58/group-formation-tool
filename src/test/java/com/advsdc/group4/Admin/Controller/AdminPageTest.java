package com.advsdc.group4.Admin.Controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.advsdc.group4.Group4Application;
import com.advsdc.group4.Admin.controller.AdminPage;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {AdminPage.class, Group4Application.class})
@AutoConfigureMockMvc
public class AdminPageTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void checkAdminHome() throws Exception {
		this.mockMvc.perform(get("/admin_home_page")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Administrator Dashboard")));	
}
	@Test
	public void checkAdminAddCourseLaunch() throws Exception {
		this.mockMvc.perform(get("/add_course_page")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("")));
	}
	@Test
	public void checkAdminDeleteCourseLaunch() throws Exception {
			this.mockMvc.perform(get(""
					+ "/add_instructor_page")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("")));
	}
	
}
