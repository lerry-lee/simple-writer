package bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ReflectiveTitleBean {
    private int id;
    private String title;
    private String sdate;
    public ReflectiveTitleBean(int id,String title,String sdate){
        this.id=id;
        this.title=title;
        this.sdate=sdate;
    }
}
