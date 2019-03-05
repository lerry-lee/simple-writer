package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.CommentsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryComments")
public class QueryCommentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int sid= Integer.parseInt(request.getParameter("sid"));
        try {
            String json= CommentsService.query(sid);
            PrintWriter out=response.getWriter();
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
