package com.sofka.proyecto.dojospringboot.Model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Builder
@Getter
@Setter
public class User {

    @Id Object id;
    private String identification;
    private String name;
    private String phone;




}
