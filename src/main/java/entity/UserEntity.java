package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserEntity {

    private int id;

    private String username;

    private String password;

    public UserEntity(String username,String password){
        this.username=username;
        this.password=password;
    }
}
