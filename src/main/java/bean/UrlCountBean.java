package bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlCountBean {
    private String url;
    private Integer times;

    public UrlCountBean(String url, Integer times){
        this.url=url;
        this.times=times;
    }

}
