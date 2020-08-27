package com.lambdaschool.howto.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.howto.HowtoApplication;
import com.lambdaschool.howto.models.User;
import com.lambdaschool.howto.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HowtoApplication.class)
@WithMockUser(username = "admin", roles = {"ADMIN"})
public class OpenControllerTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    @Test
    public void addSelf() throws Exception
    {
        String urls = "/createnewuser";

        User user = new User("test", "password");
        user.setUserid(15);

        ObjectMapper mapper = new ObjectMapper();
        String userString = mapper.writeValueAsString(user);

        Mockito.when(userService.save(any(User.class))).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(urls).accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON).content(userString);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }
}