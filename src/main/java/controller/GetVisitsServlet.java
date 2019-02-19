package controller;

import service.VisitsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getVisits")
public class GetVisitsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int visits= VisitsService.getVisits();
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(visits);
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
