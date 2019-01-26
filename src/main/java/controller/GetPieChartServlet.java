package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.HttpRequestInfoService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getPieChart")
public class GetPieChartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String json= null;
        try {
            json = HttpRequestInfoService.getUrlCount();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        PrintWriter writer= null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.write(json);
        writer.close();
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }
}
