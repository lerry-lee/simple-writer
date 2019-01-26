package service;


import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.HttpRequestInfoDaoImpl;
import entity.HttpRequestInfoEntity;
import utils.ToJson;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestInfoService {
    public static String getAll() throws JsonProcessingException {
        HttpRequestInfoDaoImpl hrtdi= new HttpRequestInfoDaoImpl();
        List<HttpRequestInfoEntity> list=new ArrayList<>();
        list=hrtdi.query();
        String list_json= ToJson.toJson(list);
        return list_json;
    }
}
