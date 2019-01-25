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
        String date=sdf.format(new Date());
        System.out.println("date:"+date);
        //获取ip
        String ip="#ip" ;
        System.out.println("ip: "+ip);
        //获取请求方法get/post
        String method=request.getMethod();
        System.out.println("method:"+method);
        //获取请求的url
        String url= String.valueOf(request.getRequestURL());
        System.out.println("url:"+url);
        //获取请求参数
        String params=request.getQueryString();
        System.out.println("params:"+params);
        //获取响应时间
        System.out.println("timeConsuming:"+t+"ms");
        //获取状态码
        int status=response.getStatus();
        System.out.println("status:"+status);

        HttpRequestInfo httpRequestInfo=new HttpRequestInfo();
        httpRequestInfo.setDate(date);
        httpRequestInfo.setIp(ip);//ip等待获取
        httpRequestInfo.setMethod(method);
        httpRequestInfo.setParam(params);
        httpRequestInfo.setStatus(status);
        httpRequestInfo.setTimeConsuming(t);
        httpRequestInfo.setUrl(url);

        return httpRequestInfo;
    }
}
