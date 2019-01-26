package entity;

public class HttpRequestTimesEntity {
    private String url;
    private Integer times;

    public HttpRequestTimesEntity() {
    }
    public HttpRequestTimesEntity(String url, Integer times){
        this.url=url;
        this.times=times;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
