
package com.sofka.proyecto.dojospringboot;

import com.sofka.proyecto.dojospringboot.Controller.UserController;
import com.sofka.proyecto.dojospringboot.Model.User;
import com.sofka.proyecto.dojospringboot.Repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    List<User> users;
    User mockUser;
    User mockUser2;

    @MockBean
    UserRepository userRepository;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void init(){
     mockUser =User.builder()
             .id("5")
             .name("John")
             .build();
             users= Arrays.asList(mockUser);
    }

    @Test
    public void testGetUser()throws Exception{
        doReturn(Optional.of(mockUser)).when(userRepository).findUserById("5");
        mockMvc.perform(get("/api/v1/user/{id}", 5))
                .andExpect(status().isOk());
    }

    @Test
    public void testAllUsers() throws Exception {

        when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/v1/users").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"));

    }







}

