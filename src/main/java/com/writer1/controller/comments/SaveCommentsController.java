package com.writer1.controller.comments;

import com.writer1.service.CommentsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/saveComments")
public class SaveCommentsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid= Integer.parseInt(request.getParameter("sid"));
        String comment=request.getParameter("comment");
        int niming= Integer.parseInt(request.getParameter("niming"));
        String commentator= niming==1?"匿名用户": (String) request.getSession().getAttribute("username");
        if(commentator==null) return;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String cdate = df.format(new Date());
        PrintWriter out=response.getWriter();
        out.print(new CommentsService().save(sid,comment,cdate,commentator));
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
