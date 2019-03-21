package com.writer1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Contact {
    private int id;
    private String username;
    private String name;
    private String email;
    private String comments;
    public Contact(String username,String name,String email,String comments){
        this.username=username;
        this.name=name;
        this.email=email;
        this.comments=comments;
    }
}
