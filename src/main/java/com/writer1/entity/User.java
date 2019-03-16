package com.writer1.entity;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {
    private Integer id;

    private String username;

    private String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
}
