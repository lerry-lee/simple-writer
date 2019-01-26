package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.HttpRequestInfoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getAllHttpInfo")
public class GetAllHttpInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            String list= HttpRequestInfoService.getAll();
            PrintWriter out=response.getWriter();
            out.write(list);
            out.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }
}
