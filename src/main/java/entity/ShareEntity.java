package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShareEntity {
    private int id;
    private String author;
    private String sdate;
    private String category;
    private String content;
    private String title;
    private int totalComments;
    public ShareEntity(int id, String sdate, String category,String content, String title,int totalComments,String author){
        this.id=id;
        this.sdate=sdate;
        this.category=category;
        this.content=content;
        this.title=title;
        this.totalComments=totalComments;
        this.author = author;
    }
    public ShareEntity(int id, String sdate, String category,String content, String title,int totalComments){
        this.id=id;
        this.sdate=sdate;
        this.category=category;
        this.content=content;
        this.title=title;
        this.totalComments=totalComments;
    }
    public ShareEntity(String author, String sdate, String category, String content, String title){
        this.author = author;
        this.sdate=sdate;
        this.category=category;
        this.content=content;
        this.title=title;
    }
}
