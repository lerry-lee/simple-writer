package bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommentsBean {
    private String comment;
    private String cdate;
    private String commentator;
    public  CommentsBean(String comment,String cdate,String commentator){
        this.comment=comment;
        this.cdate=cdate;
        this.commentator = commentator;
    }
}
