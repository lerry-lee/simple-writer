package service;


import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.HttpRequestInfoDaoImpl;
import entity.HttpRequestInfoEntity;
import entity.HttpRequestTimesEntity;
import utils.ToJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

public class HttpRequestInfoService {

    public static String getAll() throws JsonProcessingException {
        HttpRequestInfoDaoImpl hrtdi= new HttpRequestInfoDaoImpl();
        List<HttpRequestInfoEntity> list=hrtdi.query();
        String list_json= ToJson.toJson(list);
        return list_json;
    }
    //返回url和访问次数
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
    //将filter拦截的http请求信息写入数据库
    public static void filterInsert(HttpServletRequest request, HttpServletResponse response, long t){
        //获取当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());
        //获取ip
        String ip="#ip" ;
        //获取请求方法get/post
        String method=request.getMethod();
        //获取请求的url
        String url= String.valueOf(request.getRequestURL());
        //获取请求参数
        String params=request.getQueryString();
        //获取状态码
        int status=response.getStatus();

        HttpRequestInfoEntity httpRequestInfoEntity =new HttpRequestInfoEntity(date,url,ip,params,method,status,t);
        HttpRequestInfoDaoImpl h=new HttpRequestInfoDaoImpl();
        h.insert(httpRequestInfoEntity);
    }
}
