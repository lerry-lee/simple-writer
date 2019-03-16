package com.writer1.controller.user;


import com.writer1.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username"),
                password = request.getParameter("password");
        int result = new UserService().queryByUsernameAndPassword(username, password);
        if (result > 0) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String sdate = df.format(new Date());
            System.out.println(username + "已登录 " + sdate);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
        PrintWriter out = response.getWriter();
        out.print(result);
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
