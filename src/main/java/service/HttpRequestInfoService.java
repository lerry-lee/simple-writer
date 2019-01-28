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
        HttpRequestInfoDaoImpl hrtdi = new HttpRequestInfoDaoImpl();
        List<HttpRequestInfoEntity> list = hrtdi.query();
        String list_json = ToJson.toJson(list);
        return list_json;
    }

    //返回url和访问次数
    public static String getUrlCount() throws JsonProcessingException {
        HttpRequestInfoDaoImpl h = new HttpRequestInfoDaoImpl();
        List<HttpRequestTimesEntity> list = h.queryCount();
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

    //将filter拦截的http请求信息写入数据库
    public static void filterInsert(String date, String url, String ip, String param, String method, Integer status, long t) {
        HttpRequestInfoEntity httpRequestInfoEntity = new HttpRequestInfoEntity(date, url, ip, param, method, status, t);
        HttpRequestInfoDaoImpl h = new HttpRequestInfoDaoImpl();
        h.insert(httpRequestInfoEntity);
    }

    //通过url模糊查询
    public static String urlGetAll(String query_url,String start_date,String end_date,String status) {
        HttpRequestInfoDaoImpl hrtdi = new HttpRequestInfoDaoImpl();
        List<HttpRequestInfoEntity> list = hrtdi.fuzzyQuery(query_url,start_date,end_date,status);
        String list_json = null;
        try {
            list_json = ToJson.toJson(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list_json;
    }
}
