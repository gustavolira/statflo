package com.statflo.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.statflo.api.model.User;
import com.statflo.api.model.swaggerView.UserView;
import com.statflo.api.service.UserService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private UserService service;

	@Autowired
	ObjectMapper mapper;
	
	public void shouldCreateUser() throws Exception {
		UserView user = new UserView();
		user.setName("Ovatsug Aril");
		user.setRole("master");
		this.mvc.perform(
				post("/users/").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(user)))
				.andExpect(status().isCreated());
	}

	
	@Test
	public void shouldFindUserCreated() throws Exception {
		this.createUser();
		mvc.perform(get("/users/?role=admin"))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$", hasSize(1)))
			      .andExpect(jsonPath("$[0].name", is("Gustavo Lira")));
	}
	
	private void createUser() throws Exception {
		User user = new User();
		user.setName("Gustavo Lira");
		user.setRole("admin");
		service.save(user);
	}

}