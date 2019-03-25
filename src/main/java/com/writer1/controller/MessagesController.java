package com.writer1.controller;

import com.writer1.service.impl.MessagesServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@Controller
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;
    /*
     * 保存一次消息
     * @param author 帖子的作者
     * @param commentator 评论者
     * @param sid 帖子的id
     * @param comment 评论内容
     * @param title 帖子的标题
     * */
    @RequestMapping("/saveMessages")
    public void saveMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = request.getParameter("author");
        String commentator = (String) SecurityUtils.getSubject().getPrincipal();
        int sid = Integer.parseInt(request.getParameter("sid"));
        String comment = request.getParameter("comment");
        String title = URLDecoder.decode(request.getParameter("title"), "UTF-8");
        printWriter(response, messagesService.save(author, commentator, sid, comment, title));
    }
    /*
     * 查询所有消息
     * @param username 当前用户名
     * */
    @RequestMapping("/queryMessages")
    public void queryMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        printWriter(response, messagesService.query(username));
    }
    /*
     * 已读一条消息
     * @param username 当前用户名
     * @param id 消息的id
     * */
    @RequestMapping("/readMessages")
    public void readMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int id = Integer.parseInt(request.getParameter("mid"));
        printWriter(response, messagesService.read(username, id));
    }
    /*
     * 查询未读消息数量
     * @param username 当前用户名
     * */
    @RequestMapping("/countMessages")
    public void countMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        printWriter(response, messagesService.count(username));
    }
    /*
     * 已读所有消息
     * @param username 当前用户名
     * */
    @RequestMapping("/readAllMessages")
    public void readAllMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        printWriter(response, messagesService.readAll(username));
    }
    /*
     * 返回json给ajax
     * @param obj
     * */
    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
