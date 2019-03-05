package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShareEntity {
    private int id;
    private String username;
    private String sdate;
    private String category;
    private int dianzan;
    private String content;
    private String title;
    private int totalComments;
    public ShareEntity(int id, String sdate, String category, int dianzan, String content, String title,int totalComments){
        this.id=id;
        this.sdate=sdate;
        this.category=category;
        this.dianzan = dianzan;
        this.content=content;
        this.title=title;
        this.totalComments=totalComments;
    }
    public ShareEntity(String username,String sdate,String category,String content,String title){
        this.username=username;
        this.sdate=sdate;
        this.category=category;
        this.content=content;
        this.title=title;
    }
}
