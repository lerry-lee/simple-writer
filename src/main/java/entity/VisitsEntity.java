package entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VisitsEntity {
    private int id;
    private String username;
    private int times;

    public VisitsEntity(String username,int times){
        this.username=username;
        this.times=times;
    }
}
