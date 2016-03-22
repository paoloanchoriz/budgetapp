package com.apolloproject.budget.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class LandingPageControllerTest {

	@Test
	public void testHomePage() throws Exception {
		LandingPageController landingPage = new LandingPageController();
		MockMvc mockMvc = standaloneSetup(landingPage).build();
		
		mockMvc.perform(get("/").param("name", "Apollo"))
			.andExpect(view().name("landingPage"))
			.andExpect(model().attributeExists("name"))
			.andExpect(model().attribute("name", "Apollo"));
	}

}
