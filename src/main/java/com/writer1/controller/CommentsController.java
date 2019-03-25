package com.writer1.controller;

import com.writer1.service.impl.CommentsServiceImpl;
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
public class CommentsController {
    @Autowired
    private CommentsServiceImpl commentsService;
    /*
    * 保存一次评论
    * @param sid 帖子的id
    * @param comment 评论内容
    * @param niming 是否匿名
    * @param commentator 评论者（正在登录的用户）
    * @param sdate 评论时间 格式：日 月份 年
    * */
    @RequestMapping("/saveComments")
    public void saveComments(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String comment = request.getParameter("comment");
        int niming = Integer.parseInt(request.getParameter("niming"));
        String commentator = niming == 1 ? "匿名用户" : (String) SecurityUtils.getSubject().getPrincipal();
        if (commentator == null) return;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String cdate = df.format(new Date());
        printWriter(response, commentsService.save(sid, comment, cdate, commentator));
    }
    /*
     * 查询所有评论
     * @param sid 帖子的id
     * */
    @RequestMapping("/queryComments")
    public void queryComments(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        printWriter(response, commentsService.query(sid));
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
