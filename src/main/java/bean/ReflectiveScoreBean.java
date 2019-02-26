package bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ReflectiveScoreBean {
    private String sdate;
    private int self;
    private int comparison;
    private int summary;
    private int automatic;
    public ReflectiveScoreBean(String sdate,int self,int comparison,int summary,int automatic){
        this.sdate=sdate;
        this.self=self;
        this.comparison=comparison;
        this.automatic=automatic;
    }
}
