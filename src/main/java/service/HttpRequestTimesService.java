package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.HttpRequestTimesDaoImpl;
import entity.HttpRequestTimesEntity;
import utils.ToJson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpRequestTimesService {
    public static String getAll() throws JsonProcessingException {
        //从数据库中获取http请求访问次数
        HttpRequestTimesDaoImpl httpRequestTimesDao = new HttpRequestTimesDaoImpl();
        //将返回的list集合转换成map集合
        List<HttpRequestTimesEntity> list = httpRequestTimesDao.query();
        Map<String, Integer> map = new HashMap<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            HttpRequestTimesEntity hrt = (HttpRequestTimesEntity) iterator.next();
            map.put(hrt.getUrl(), hrt.getTimes());
        }
        //将map对象转换成json字符串
        String map_json = ToJson.toJson(map);
//        System.out.println("测试list_json: "+map_json);
        return map_json;
    }
}
