package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MessagesEntity {
//    private int id;
    private int sid;
    private String message;
    private int isRead;
    private String comment;
    public MessagesEntity(int sid, String message,String comment){
        this.sid=sid;
        this.message=message;
        this.comment=comment;
    }
    public MessagesEntity(String message,String comment){
        this.message=message;
        this.comment=comment;
    }
}
