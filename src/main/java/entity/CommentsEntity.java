package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommentsEntity {
    private int id;
    private int sid;
    private String comment;
    private String cdate;
    public CommentsEntity(int sid,String comment,String cdate){
        this.sid=sid;
        this.comment =comment;
        this.cdate=cdate;
    }
    public CommentsEntity(String comment,String cdate){
        this.comment =comment;
        this.cdate=cdate;
    }
}
