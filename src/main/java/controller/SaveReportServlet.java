package controller;

import entity.ReportEntity;
import service.ReportService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveReport")
public class SaveReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ReportEntity report=new ReportEntity((String) request.getSession().getAttribute("username"),request.getParameter("content"));
        boolean flag= ReportService.saveReport(report);
        if(flag){
            PrintWriter out= null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("1");
            out.close();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
