package com.writer1.controller;

import com.writer1.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CommentsController {
    @RequestMapping("/saveComments")
    public void saveComments(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String comment = request.getParameter("comment");
        int niming = Integer.parseInt(request.getParameter("niming"));
        String commentator = niming == 1 ? "匿名用户" : (String) request.getSession().getAttribute("username");
        if (commentator == null) return;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String cdate = df.format(new Date());
        printWriter(response, new CommentsService().save(sid, comment, cdate, commentator));
    }

    @RequestMapping("/queryComments")
    public void queryComments(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        printWriter(response, new CommentsService().query(sid));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
