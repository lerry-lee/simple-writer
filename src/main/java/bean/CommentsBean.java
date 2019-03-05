package bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommentsBean {
    private String comment;
    private String cdate;
    public  CommentsBean(String comment,String cdate){
        this.comment=comment;
        this.cdate=cdate;
    }
}
