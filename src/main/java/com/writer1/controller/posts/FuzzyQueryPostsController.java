package com.writer1.controller.posts;

import com.writer1.service.PostsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fuzzyQueryPosts")
public class FuzzyQueryPostsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key_words=request.getParameter("key_words");
        String category=request.getParameter("category");
        String author=request.getParameter("author");
        if(author.equals("My"))
            author= (String) request.getSession().getAttribute("username");
        PrintWriter out=response.getWriter();
        out.print(new PostsService().fuzzyQuery(key_words,category,author));
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
