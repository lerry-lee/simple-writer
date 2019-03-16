package com.writer1.controller.reflective;

import com.writer1.service.ReflectiveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fuzzyQuery")
public class FuzzyQueryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username= (String) request.getSession().getAttribute("username");
        String title=request.getParameter("title");
        String start_date=request.getParameter("start_date");
        String end_date=request.getParameter("end_date");
        int page= Integer.parseInt(request.getParameter("page"));
        int rows= Integer.parseInt(request.getParameter("limit"));
        int offset=(page-1)*rows;
        PrintWriter out=response.getWriter();
        out.print(new ReflectiveService().fuzzyQuery(username,title,start_date,end_date,offset,rows));
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
