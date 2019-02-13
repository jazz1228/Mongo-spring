package com.sofka.proyecto.dojospringboot.Repository;

import com.sofka.proyecto.dojospringboot.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {

    User findUserById(String id);
    void deleteUserById(String id);

}
