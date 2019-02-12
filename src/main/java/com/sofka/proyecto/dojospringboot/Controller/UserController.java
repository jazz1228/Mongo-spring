package com.sofka.proyecto.dojospringboot.Controller;

import com.sofka.proyecto.dojospringboot.Model.User;
import com.sofka.proyecto.dojospringboot.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
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
    public List<User> getAlUsers() {
        return userRepository.findAll();

    }

    @PostMapping("createUser")
    public String createUser(@RequestBody String userData) throws JSONException {
        JSONObject userObject = new JSONObject(userData);

        String name = userObject.getString("name");
        String identification = userObject.getString("identification");
        String telephoneNumber = userObject.getString("number");

        User user = User.builder()
                .id(ObjectId.get())
                .identification(identification)
                .name(name)
                .phone(telephoneNumber)
                .build();
        userRepository.save(user);
        return this.WARNINGMESSAGE+" saved Succesfully";
    }

    @PutMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") String id,@RequestBody String changesUser) throws JSONException {

        User user=userRepository.findUserByIdentification(id);
        JSONObject changesObject=new JSONObject(changesUser);

        String name=changesObject.getString("name");
        String identification=changesObject.getString("identification");
        String telephoneNumber=changesObject.getString("number");

        user.setIdentification(identification);
        user.setName(name);
        user.setPhone(telephoneNumber);

        userRepository.save(user);

        return this.WARNINGMESSAGE+" updated Succesfully";

    }

    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id")String id){
        userRepository.deleteUserByIdentification(id);
        return this.WARNINGMESSAGE+" deleted Succesfully";
    }





}
