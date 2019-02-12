
package com.sofka.proyecto.dojospringboot;

import com.sofka.proyecto.dojospringboot.Controller.UserController;
import com.sofka.proyecto.dojospringboot.Model.User;
import com.sofka.proyecto.dojospringboot.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    List<User> users;

    @MockBean
    UserRepository userRepository;


    @Autowired
    MockMvc mockMvc;

    @Before
    public void init(){
        User user=User.builder()
                .id(ObjectId.get())
                .name("John")
                .identification("1231234124")
                .build();
        users= Arrays.asList(user);
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

