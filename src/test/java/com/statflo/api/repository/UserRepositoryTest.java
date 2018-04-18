package com.statflo.api.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.statflo.api.model.User;
import com.statflo.api.service.UserService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class UserRepositoryTest {

    @Autowired
    private UserService service;

    @Test
    public void testFindByName() {
    	User user = new User();
    	user.setName("Joseph");
    	user.setRole("user");
    	
    	service.save(user);

        List<User> userFinded = service.findByRole("user");
        assertEquals("user", userFinded.get(0).getRole());
    }
}