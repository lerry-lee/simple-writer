package entity;

import java.util.Date;

public class HttpRequestInfoEntity {
    private int id;
    private String date;
    private String url;
    private String ip;
    private String param;
    private long timeConsuming;
    private String method;
    private Integer status;

    public HttpRequestInfoEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setTimeConsuming(long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public long getTimeConsuming() {
        return timeConsuming;
    }

    public String getParam() {
        return param;
    }

    public String getIp() {
        return ip;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
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
