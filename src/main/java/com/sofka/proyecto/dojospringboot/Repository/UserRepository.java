package com.sofka.proyecto.dojospringboot.Repository;

import com.sofka.proyecto.dojospringboot.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends MongoRepository<User,String> {

    User findUserById(String id);
    void deleteUserById(String id);

}
