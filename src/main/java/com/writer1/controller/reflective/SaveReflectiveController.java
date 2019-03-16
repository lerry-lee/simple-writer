package com.writer1.controller.reflective;

import com.writer1.service.ReflectiveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/saveReflective")
public class SaveReflectiveController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        if(username==null) return;
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int self = Integer.parseInt(request.getParameter("self"));
        int comparison = Integer.parseInt(request.getParameter("comparison"));
        int summary = Integer.parseInt(request.getParameter("summary"));
        int automatic = Integer.parseInt(request.getParameter("automatic"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String sdate = df.format(new Date());
        int rst = new ReflectiveService().save(username, title, content, self, comparison, summary, automatic, sdate);
        PrintWriter out = response.getWriter();
        out.print(rst);
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
