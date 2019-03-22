package com.writer1.controller;

import com.writer1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/checkUsername")
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        printWriter(response, userServiceImpl.queryByUsername(username));
    }

    @RequestMapping("/getUsername")
    public void getUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        printWriter(response, request.getSession().getAttribute("username"));
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username"),
                password = request.getParameter("password");
        int result = userServiceImpl.queryByUsernameAndPassword(username, password);
        if (result > 0) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String sdate = df.format(new Date());
            System.out.println(username + "已登录 " + sdate);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
        printWriter(response, result);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String sdate = df.format(new Date());
        System.out.println(request.getSession().getAttribute("username") + "已登出 " + sdate);
        request.getSession().removeAttribute("username");
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username"),
                password = request.getParameter("password");
        printWriter(response, userServiceImpl.addUser(username, password));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
