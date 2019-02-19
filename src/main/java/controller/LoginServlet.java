package controller;

import entity.UserEntity;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        UserEntity user=new UserEntity( request.getParameter("username"),request.getParameter("password"));
        if (UserService.login(user)) {
            try {
                HttpSession session=request.getSession();
                session.setAttribute("username",user.getUsername());
                PrintWriter out = response.getWriter();
                String rst="{\"status\":\"1\",\"url\":\"home.jsp\"}";
                out.print(rst);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PrintWriter out = response.getWriter();
                String rst="{\"status\":\"0\",\"msg\":\"用户名或密码错误\"}";
                out.print(rst);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
