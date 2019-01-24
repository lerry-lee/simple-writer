package utils;

import entity.HttpRequestInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log extends HttpServlet {
    public static HttpRequestInfo httpRequestLog(HttpServletRequest request, HttpServletResponse response,long t){
        //获取当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("date:"+sdf.format(new Date()));
        //获取ip
        System.out.println("ip: "+"#ip");
        //获取请求方法get/post
        System.out.println("method:"+request.getMethod());
        //获取请求的url
        System.out.println("url:"+request.getRequestURL());
        //获取请求参数
        System.out.println("params:"+request.getRequestURI());
        //获取响应时间
        System.out.println("timeConsuming:"+t+"ms");
        //获取状态码
        System.out.println("status:"+response.getStatus());

        HttpRequestInfo httpRequestInfo=new HttpRequestInfo();
        httpRequestInfo.setDate(sdf.format(new Date()));
        httpRequestInfo.setIp("#ip");//ip等待获取
        httpRequestInfo.setMethod(request.getMethod());
        httpRequestInfo.setParam(request.getRequestURI());
        httpRequestInfo.setStatus(response.getStatus());
        httpRequestInfo.setTimeConsuming(t);
        httpRequestInfo.setUrl(String.valueOf(request.getRequestURL()));

        return httpRequestInfo;
    }
}
