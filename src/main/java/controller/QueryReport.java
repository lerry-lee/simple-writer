package controller;

import service.ReportService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryReport")
public class QueryReport extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String username= (String) request.getSession().getAttribute("username");
        String content=ReportService.queryContent(username);
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(content);
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
