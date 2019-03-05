package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.ShareService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryShare")
public class QueryShareServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        int page= Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*5;
        int rows=5;
        String json= null;
        try {
            json = ShareService.query(offset,rows);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(json);
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }

}
