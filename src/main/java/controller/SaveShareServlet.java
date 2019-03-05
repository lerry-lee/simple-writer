package controller;

import entity.ShareEntity;
import service.ShareService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/saveShare")
public class SaveShareServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String content=request.getParameter("content");
        String title=request.getParameter("title");
        String category=request.getParameter("category");
        String username= (String) request.getSession().getAttribute("username");
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String sdate = df.format(new Date());
        boolean flag= ShareService.save(username,sdate,category,content,title);
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
