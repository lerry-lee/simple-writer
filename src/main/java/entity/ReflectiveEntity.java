package entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ReflectiveEntity {
    private int id;
    private String title;
    private String content;
    private int self;
    private int comparison;
    private int summary;
    private int automatic;
    private String sdate;

    public ReflectiveEntity(String title, String content, int self, int comparison, int summary, int automatic, String sdate){
        this.title=title;
        this.content=content;
        this.self=self;
        this.comparison=comparison;
        this.summary=summary;
        this.automatic=automatic;
        this.sdate=sdate;
    }
    public ReflectiveEntity(int id, String titile, String sdate){
        this.id=id;
        this.title=titile;
        this.sdate=sdate;
    }
}
