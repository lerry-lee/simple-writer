package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpRequestInfoEntity {
    private int id;
    private String date;
    private String url;
    private String ip;
    private String param;
    private long timeConsuming;
    private String method;
    private Integer status;

    public HttpRequestInfoEntity(String date, String url, String ip, String param, String method, Integer status,long timeConsuming){
        this.date=date;
        this.ip=ip;
        this.method=method;
        this.param=param;
        this.status=status;
        this.timeConsuming=timeConsuming;
        this.url=url;
    }
    public HttpRequestInfoEntity(int id,String date, String url, String ip, String param, String method, Integer status,long timeConsuming){
        this.id=id;
        this.date=date;
        this.ip=ip;
        this.method=method;
        this.param=param;
        this.status=status;
        this.timeConsuming=timeConsuming;
        this.url=url;
    }
}
