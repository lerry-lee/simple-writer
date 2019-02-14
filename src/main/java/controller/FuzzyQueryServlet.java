package controller;

import service.HttpRequestInfoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fuzzyQuery")
public class FuzzyQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String query_url = request.getParameter("url");
        String start_date=request.getParameter("startDate");
        String end_date=request.getParameter("endDate");
        String method=request.getParameter("method");
        String page=request.getParameter("page");
        String limit=request.getParameter("limit");
        int rows=Integer.parseInt(limit);
        int offset=(Integer.parseInt(page)-1)*rows;
        String json = HttpRequestInfoService.fuzzyQuery(offset,rows,query_url,start_date,end_date,method);

        try {
            PrintWriter out = response.getWriter();
            out.write(json);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
