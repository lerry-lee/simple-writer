package controller;

import entity.UserEntity;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        UserEntity user = new UserEntity((String) request.getSession().getAttribute("username"), request.getParameter("password_old"));
        boolean flag = UserService.changePassword(user, request.getParameter("password_new"));
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag) {
            out.print("1");
        } else out.print("0");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
