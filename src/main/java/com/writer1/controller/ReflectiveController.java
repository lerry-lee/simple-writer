package com.writer1.controller;

import com.writer1.service.impl.ReflectiveServiceImpl;
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
public class ReflectiveController {
    @Autowired
    private ReflectiveServiceImpl reflectiveService;

    @RequestMapping("/saveReflective")
    public void saveReflective(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username == null) return;
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int self = Integer.parseInt(request.getParameter("self"));
        int comparison = Integer.parseInt(request.getParameter("comparison"));
        int summary = Integer.parseInt(request.getParameter("summary"));
        int automatic = Integer.parseInt(request.getParameter("automatic"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String sdate = df.format(new Date());
        printWriter(response, reflectiveService.add(username, title, content, self, comparison, summary, automatic, sdate));
    }

    @RequestMapping("/getTitle")
    public void getTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("limit"));
        int offset = (page - 1) * rows;
        printWriter(response, reflectiveService.queryTitle(username, offset, rows));
    }

    @RequestMapping("/getScore")
    public void getScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        printWriter(response, reflectiveService.queryScore(username));
    }

    @RequestMapping("/fuzzyQueryReflective")
    public void fuzzyQueryReflective(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        String title = request.getParameter("title");
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("limit"));
        int offset = (page - 1) * rows;
        printWriter(response, reflectiveService.fuzzyQuery(username, title, start_date, end_date, offset, rows));
    }

    @RequestMapping("/deleteFromReflective")
    public void deleteFromReflective(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int id = Integer.parseInt(request.getParameter("id"));
        printWriter(response, reflectiveService.delete(username, id));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
