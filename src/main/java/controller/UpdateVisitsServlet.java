package controller;

import service.VisitsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateVisits")
public class UpdateVisitsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String username=(String) httpServletRequest.getSession().getAttribute("username");
        boolean flag= VisitsService.insert(username);
        if(flag) {
            PrintWriter out = null;
            try {
                out = httpServletResponse.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print(username);
            out.close();
        }
    }
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        doGet(httpServletRequest, httpServletResponse);
    }
}

