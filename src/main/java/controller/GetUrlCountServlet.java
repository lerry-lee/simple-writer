package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.HttpRequestInfoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getUrlCount")
public class GetUrlCountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String json = null;
        try {
            json = HttpRequestInfoService.getUrlCount();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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
