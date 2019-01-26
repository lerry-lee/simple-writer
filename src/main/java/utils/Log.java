package utils;

import entity.HttpRequestInfoEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log extends HttpServlet {
    public static HttpRequestInfoEntity httpRequestLog(HttpServletRequest request, HttpServletResponse response, long t){
        //获取当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());
//        System.out.println("date:"+date);
        //获取ip
        String ip="#ip" ;
//        System.out.println("ip: "+ip);
        //获取请求方法get/post
        String method=request.getMethod();
//        System.out.println("method:"+method);
        //获取请求的url
        String url= String.valueOf(request.getRequestURL());
//        System.out.println("url:"+url);
        //获取请求参数
        String params=request.getQueryString();
//        System.out.println("params:"+params);
        //获取响应时间
//        System.out.println("timeConsuming:"+t+"ms");
        //获取状态码
        int status=response.getStatus();
//        System.out.println("status:"+status+"\n");

        HttpRequestInfoEntity httpRequestInfoEntity =new HttpRequestInfoEntity();
        httpRequestInfoEntity.setDate(date);
        httpRequestInfoEntity.setIp(ip);//ip等待获取
        httpRequestInfoEntity.setMethod(method);
        httpRequestInfoEntity.setParam(params);
        httpRequestInfoEntity.setStatus(status);
        httpRequestInfoEntity.setTimeConsuming(t);
        httpRequestInfoEntity.setUrl(url);

        return httpRequestInfoEntity;
    }
}
