package entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VisitsEntity {
    private int id;
    private String usersign;

    public VisitsEntity(String usersign) {
        this.usersign = usersign;
    }
}
