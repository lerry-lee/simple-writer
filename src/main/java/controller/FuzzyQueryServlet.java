package controller;

import service.HttpRequestInfoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet("/fuzzyQuery")
public class FuzzyQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String query_url = request.getParameter("url");
        String start_date=request.getParameter("startDate");
        String end_date=request.getParameter("endDate");
        String status=request.getParameter("status");
        String json = HttpRequestInfoService.urlGetAll(query_url,start_date,end_date,status);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(json);
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
