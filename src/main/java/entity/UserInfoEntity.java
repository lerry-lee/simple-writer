package entity;

import lombok.Getter;
import lombok.Setter;

public class UserInfoEntity {
    @Getter@Setter
    private int id;
    @Getter@Setter
    private String username;
    @Getter@Setter
    private String password;
}
