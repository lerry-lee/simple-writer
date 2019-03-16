package com.writer1.controller.reflective;

import com.writer1.service.ReflectiveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteFromReflective")
public class DeleteFromReflectiveController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username= (String) request.getSession().getAttribute("username");
        int id= Integer.parseInt(request.getParameter("id"));
        PrintWriter out=response.getWriter();
        out.print(new ReflectiveService().delete(username,id));
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
