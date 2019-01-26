package service;


import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.HttpRequestInfoDaoImpl;
import entity.HttpRequestInfoEntity;
import entity.HttpRequestTimesEntity;
import utils.ToJson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpRequestInfoService {
    public static String getAll() throws JsonProcessingException {
        HttpRequestInfoDaoImpl hrtdi= new HttpRequestInfoDaoImpl();
        List<HttpRequestInfoEntity> list=hrtdi.query();
        String list_json= ToJson.toJson(list);
        return list_json;
    }
    public static String getUrlCount() throws JsonProcessingException {
        HttpRequestInfoDaoImpl h=new HttpRequestInfoDaoImpl();
        List<HttpRequestTimesEntity> list=h.queryCount();
//        String list_json=ToJson.toJson(list);
        Map<String, Integer> map = new HashMap<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            HttpRequestTimesEntity hrt = (HttpRequestTimesEntity) iterator.next();
            map.put(hrt.getUrl(), hrt.getTimes());
        }
        //将map对象转换成json字符串
        String map_json = ToJson.toJson(map);
        return map_json;
    }
}
