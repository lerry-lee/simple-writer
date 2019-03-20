package com.writer1.controller;

import com.writer1.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PostsController {
    @RequestMapping("/savePosts")
    public void savePosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = (String) request.getSession().getAttribute("username");
        if (author == null) return;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String sdate = df.format(new Date());
        String category = request.getParameter("category");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        printWriter(response, new PostsService().save(author, sdate, category, content, title));
    }

    @RequestMapping("/queryAllPosts")
    public void queryAllPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        printWriter(response, new PostsService().queryAll());
    }

    @RequestMapping("/queryMyPosts")
    public void queryMyPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = (String) request.getSession().getAttribute("username");
        printWriter(response, new PostsService().queryMy(author));
    }

    @RequestMapping("/queryPostsByCategory")
    public void queryPostsByCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        if (author.equals("My"))
            author = (String) request.getSession().getAttribute("username");
        printWriter(response, new PostsService().queryByCategory(category, author));
    }

    @RequestMapping("/fuzzyQueryPosts")
    public void fuzzyQueryPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key_words = request.getParameter("key_words");
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        if (author.equals("My"))
            author = (String) request.getSession().getAttribute("username");
        printWriter(response, new PostsService().fuzzyQuery(key_words, category, author));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
