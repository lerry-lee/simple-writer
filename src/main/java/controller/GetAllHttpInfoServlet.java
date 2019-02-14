package controller;


import service.HttpRequestInfoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getAllHttpInfo")
public class GetAllHttpInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String page=request.getParameter("page");
            String limit=request.getParameter("limit");
            int rows=Integer.parseInt(limit);
            int offset=(Integer.parseInt(page)-1)*rows;
            String list = HttpRequestInfoService.getAll(offset,rows);
            PrintWriter out = response.getWriter();
            out.print(list);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
