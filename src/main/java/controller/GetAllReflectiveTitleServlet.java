package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.ReflectiveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getAllReflectiveTitle")
public class GetAllReflectiveTitleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String username = (String) request.getSession().getAttribute("username");
        String page=request.getParameter("page");
        String limit=request.getParameter("limit");
        int rows=Integer.parseInt(limit);
        int offset=(Integer.parseInt(page)-1)*rows;
        String json = null;
        try {
            json = ReflectiveService.getAll(username, offset,rows);


            PrintWriter out = null;

            out = response.getWriter();
            out.print(json);
            out.close();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
