package com.sofka.proyecto.dojospringboot.Model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Data
@NoArgsConstructor
@Builder
public class User {

    @
    @Id private String id;
    private String name;
    private String phone;

    public User(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
