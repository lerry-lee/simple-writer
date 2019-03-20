package com.writer1.controller;

import com.writer1.service.MessagesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@Controller
public class MessagesController {
    @RequestMapping("/saveMessages")
    public void saveMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = request.getParameter("author");
        String commentator = (String) request.getSession().getAttribute("username");
        int sid = Integer.parseInt(request.getParameter("sid"));
        String comment = request.getParameter("comment");
        String title = URLDecoder.decode(request.getParameter("title"), "UTF-8");
        printWriter(response, new MessagesService().save(author, commentator, sid, comment, title));
    }

    @RequestMapping("/queryMessages")
    public void queryMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        printWriter(response, new MessagesService().query(username));
    }

    @RequestMapping("/readMessages")
    public void readMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        int id = Integer.parseInt(request.getParameter("mid"));
        printWriter(response, new MessagesService().read(username, id));
    }

    @RequestMapping("/countMessages")
    public void countMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        printWriter(response, new MessagesService().count(username));
    }

    @RequestMapping("/readAllMessages")
    public void readAllMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        printWriter(response, new MessagesService().readAll(username));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
