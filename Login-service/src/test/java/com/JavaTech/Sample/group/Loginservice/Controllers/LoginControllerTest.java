package com.JavaTech.Sample.group.Loginservice.Controllers;
import com.JavaTech.Sample.group.Loginservice.Model.RegisterUserModel;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;

import com.JavaTech.Sample.group.Loginservice.Model.RequestModel;
import com.JavaTech.Sample.group.Loginservice.Service.impl.RegisterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(LoginController.class)
public class LoginControllerTest { // we specify exact class to get tested

    @Autowired
    private MockMvc mockMvc;

    @MockBean //Bean- Object
    private RegisterServiceImpl registerService; //controller -->mock service

    //service -->mock repository

    @Test
    @WithMockUser(username = "user", password = "Shiv@311",roles = "USER")//to pass basic authentication security
    public void testLoginIsSuccess() throws Exception {
        RequestModel model = new RequestModel(); // creating model
        model.setPassword("dummy");
        model.setUsername("dumyy");

        String requestString = model.toJSONString(); // request body for post method can be sent like String only.
        //so converted object into String which looks like json
        when(registerService.loginuser(any())).thenReturn("sample"); // mocking register service

        mockMvc.perform(MockMvcRequestBuilders.post("/login-service/login") //calling login url like postman
                .with(SecurityMockMvcRequestPostProcessors.csrf())// if security enable for springboot then csrf is mandetory
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestString))//setting content type //" {"usename":"mani"}"
                .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.content().string("sample"));//if request sent is success then we expect Created status 201

        //401--> unAuthorized
        //403 --> bypass security but still server says you have access but i will not give

    }

    @Test
    @WithMockUser(username = "user", password = "Shiv@311",roles = "USER")//to pass basic authentication security
    public void testRegisterIsSuccess() throws Exception {
        RegisterUserModel Mockingmodel = new RegisterUserModel(); // creating model
        Mockingmodel.setFname("siva");
        Mockingmodel.setMobile("9080499015");
        Mockingmodel.setAddress("valid address");
        Mockingmodel.setEmail("dem@dem.com");
        Mockingmodel.setLname("kumar");
        Mockingmodel.setPasssword("Shiv@3110");

        String requestString = Mockingmodel.toJSONString(); // request body for post method can be sent like String only.
        //so converted object into String which looks like json

        when(registerService.createUserData(any())).thenReturn(true); // mocking register service

        mockMvc.perform(MockMvcRequestBuilders.post("/login-service/register") //calling login url like postman
                .with(SecurityMockMvcRequestPostProcessors.csrf())// if security enable for springboot then csrf is mandetory
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestString))//setting content type //" {"usename":"mani"}"
                .andExpect(MockMvcResultMatchers.status().isCreated());


              //  .andExpect(MockMvcResultMatchers.content().)
        //if request sent is success then we expect Created status 201
        //check if response contains expected string

        //401--> unAuthorized
        //403 --> bypass security but still server says you have access but i will not give

    }

}
