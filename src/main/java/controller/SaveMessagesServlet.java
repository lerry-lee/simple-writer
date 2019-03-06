package controller;

import service.MessagesService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/saveMessages")
public class SaveMessagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String title = request.getParameter("title");
        try {
            String dtitle = URLDecoder.decode(title, "UTF-8");
            String author = request.getParameter("author");
            String commentator = (String) request.getSession().getAttribute("username");
            String comment=request.getParameter("comment");
            boolean flag = MessagesService.save(sid, dtitle, commentator, author,comment);
            PrintWriter out = null;
            out = response.getWriter();
            if (flag)
                out.print("1");
            else
                out.print("0");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

}
