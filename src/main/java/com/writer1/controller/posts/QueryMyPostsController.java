package com.writer1.controller.posts;

import com.writer1.service.PostsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryMyPosts")
public class QueryMyPostsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author= (String) request.getSession().getAttribute("username");
        PrintWriter out=response.getWriter();
        out.print(new PostsService().queryMy(author));
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
