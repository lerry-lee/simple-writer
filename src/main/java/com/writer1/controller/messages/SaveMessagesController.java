package com.writer1.controller.messages;

import com.writer1.service.MessagesService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/saveMessages")
public class SaveMessagesController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author=request.getParameter("author");
        String commentator= (String) request.getSession().getAttribute("username");
        int sid= Integer.parseInt(request.getParameter("sid"));
        String comment=request.getParameter("comment");
        String title= URLDecoder.decode(request.getParameter("title"), "UTF-8");
        PrintWriter out=response.getWriter();
        out.print(new MessagesService().save(author,commentator,sid,comment,title));
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
