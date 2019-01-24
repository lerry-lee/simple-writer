package entity;

public class HttpResultInfo {
    private Integer status;
    private String data;
    private String msg;

    public HttpResultInfo(Integer status, String data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
