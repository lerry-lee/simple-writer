package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpResultInfoEntity {
    private Integer status;
    private String data;
    private String msg;

    public HttpResultInfoEntity(Integer status, String data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

}
