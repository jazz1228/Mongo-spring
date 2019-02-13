package com.sofka.proyecto.dojospringboot.Controller;

import com.sofka.proyecto.dojospringboot.Model.User;
import com.sofka.proyecto.dojospringboot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final String INITMESSAGE = "Simple CRUD MONGO_SPRING";
    private final String WARNINGMESSAGE = "User has been";

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String initPageMessage() {
        return this.INITMESSAGE;
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("createUser")
    public String createUser(@RequestBody User userData)  {

        userRepository.save(userData);
        return this.WARNINGMESSAGE+" saved Succesfully";
    }

    @PutMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") String id ,@RequestBody User newUser)  {

        newUser.setId(id);
        userRepository.save(newUser);
        return this.WARNINGMESSAGE+" updated Succesfully";
    }

    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id")String id){
        userRepository.deleteUserById(id);
        return this.WARNINGMESSAGE+" deleted Succesfully";
    }





}
