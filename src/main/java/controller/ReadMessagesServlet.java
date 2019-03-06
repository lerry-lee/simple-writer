package controller;

import service.MessagesService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/readMessages")
public class ReadMessagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String username= (String) request.getSession().getAttribute("username");
        int sid= Integer.parseInt(request.getParameter("sid"));
        boolean flag= MessagesService.read(username,sid);
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(flag)
            out.print("1");
        else out.print("0");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }

}
