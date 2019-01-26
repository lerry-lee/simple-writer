package entity;

public class HttpRequestTimes {
    private String url;
    private Integer times;

    public HttpRequestTimes() {
    }
    public HttpRequestTimes(String url, Integer times){
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
