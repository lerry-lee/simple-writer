package com.writer1.controller.posts;

import com.writer1.service.PostsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/savePosts")
public class SavePostsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = (String) request.getSession().getAttribute("username");
        if(author==null) return;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String sdate = df.format(new Date());
        String category = request.getParameter("category");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        PrintWriter out = response.getWriter();
        out.print(new PostsService().save(author, sdate, category, content, title));
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
