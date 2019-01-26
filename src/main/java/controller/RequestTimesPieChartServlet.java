package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.HttpRequestTimesDaoImpl;
import entity.HttpRequestTimes;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/requestTimesPieChart")
public class RequestTimesPieChartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从数据库中获取http请求访问次数
        HttpRequestTimesDaoImpl httpRequestTimesDao=new HttpRequestTimesDaoImpl();
        List<HttpRequestTimes> list=new ArrayList<>();
        //将返回的list集合转换成map集合
        list=httpRequestTimesDao.query();
        Map<String,Integer> map=new HashMap<>();
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            HttpRequestTimes hrt= (HttpRequestTimes) iterator.next();
            map.put(hrt.getUrl(),hrt.getTimes());
        }
        //将map对象转换成json字符串
        ObjectMapper json=new ObjectMapper();
        String map_json=json.writeValueAsString(map);
//        System.out.println("测试list_json: "+map_json);

        PrintWriter writer=response.getWriter();
        writer.write(map_json);
        writer.close();
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
