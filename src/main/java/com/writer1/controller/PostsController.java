package com.writer1.controller;

import com.writer1.service.impl.PostsServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PostsServiceImpl postsService;

    @RequestMapping("/savePosts")
    public void savePosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = (String) SecurityUtils.getSubject().getPrincipal();
        if (author == null) return;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String sdate = df.format(new Date());
        String category = request.getParameter("category");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        printWriter(response, postsService.save(author, sdate, category, content, title));
    }

    @RequestMapping("/queryAllPosts")
    public void queryAllPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        printWriter(response, postsService.queryAll());
    }

    @RequestMapping("/queryMyPosts")
    public void queryMyPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = (String) SecurityUtils.getSubject().getPrincipal();
        printWriter(response, postsService.queryMy(author));
    }

    @RequestMapping("/queryPostsByCategory")
    public void queryPostsByCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        if (author.equals("My"))
            author = (String) request.getSession().getAttribute("username");
        printWriter(response, postsService.queryByCategory(category, author));
    }

    @RequestMapping("/fuzzyQueryPosts")
    public void fuzzyQueryPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key_words = request.getParameter("key_words");
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        if (author.equals("My"))
            author = (String) request.getSession().getAttribute("username");
        printWriter(response, postsService.fuzzyQuery(key_words, category, author));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
