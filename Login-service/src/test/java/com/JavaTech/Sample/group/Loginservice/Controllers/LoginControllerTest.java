package com.JavaTech.Sample.group.Loginservice.Controllers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;

import com.JavaTech.Sample.group.Loginservice.Model.RequestModel;
import com.JavaTech.Sample.group.Loginservice.Service.impl.RegisterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Base64;
import static org.mockito.Mockito.when;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterServiceImpl registerService;

    @Test
    @WithMockUser(username = "user", password = "Shiv@311",roles = "USER")//to pass basic authentication security
    public void testLoginIsSuccess() throws Exception {
        RequestModel model = new RequestModel(); // creating model
        model.setPassword("dummy");
        model.setUsername("dumyy");

        String requestString = model.toJSONString(); // request body for post method can be sent like String only.
        //so converted object into String which looks like json
        when(registerService.loginuser("dummy")).thenReturn("sample"); // mocking register service

        mockMvc.perform(MockMvcRequestBuilders.post("/login-service/login") //calling login url like postman
                .with(SecurityMockMvcRequestPostProcessors.csrf())// if security enable for springboot then csrf is mandetory
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestString))//setting content type
                .andExpect(MockMvcResultMatchers.status().isCreated());//if request sent is success then we expect Created status 201

    }

}
