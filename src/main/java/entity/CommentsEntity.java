package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommentsEntity {
    private int id;
    private int sid;
    private String comment;
    private String cdate;
    private String commentator;

    public CommentsEntity(int sid,String comment,String cdate,String commentator){
        this.sid=sid;
        this.comment =comment;
        this.cdate=cdate;
        this.commentator = commentator;

    }
}
