package com.writer1.controller.reflective;

import com.writer1.service.ReflectiveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getTitle")
public class GetTitleController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username= (String) request.getSession().getAttribute("username");
        int page= Integer.parseInt(request.getParameter("page"));
        int rows= Integer.parseInt(request.getParameter("limit"));
        int offset=(page-1)*rows;
        PrintWriter out=response.getWriter();
        out.print(new ReflectiveService().queryTitle(username,offset,rows));
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
