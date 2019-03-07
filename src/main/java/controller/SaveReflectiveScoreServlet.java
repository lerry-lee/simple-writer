package controller;

import service.ReflectiveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/saveReflectiveScore")
public class SaveReflectiveScoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String username= (String) request.getSession().getAttribute("username");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String sdate = df.format(new Date());
        boolean flag= ReflectiveService.save(username,request.getParameter("title"),request.getParameter("content"),request.getParameter("self"),request.getParameter("comparison"),request.getParameter("summary"),request.getParameter("automatic"),sdate);
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(flag)
            out.print("1");
        else
            out.print("0");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}

