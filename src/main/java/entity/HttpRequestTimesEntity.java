package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpRequestTimesEntity {
    private String url;
    private Integer times;

    public HttpRequestTimesEntity(String url, Integer times){
        this.url=url;
        this.times=times;
    }

}
