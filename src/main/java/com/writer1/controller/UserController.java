package com.writer1.controller;

import com.writer1.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /*
     * 检查用户名是否已存在
     * @param username 注册用户名
     * */
    @RequestMapping("/checkUsername")
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        printWriter(response, userServiceImpl.queryByUsername(username));
    }

    /*
     * 获得登录状态
     * @param username 当前登陆用户名
     * */
    @RequestMapping("/getUsername")
    public void getUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        logger.info("当前用户为{}",username);
        printWriter(response, username);
    }

    /*
     * 登陆请求
     * @param username 用户名
     * @param password 密码
     * */
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username"),
                password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            logger.info(username + "已登录 ");
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            printWriter(response, 1);
        } catch (AuthenticationException e) {
            printWriter(response, 0);
        }
    }

    /*
     * 退出登录
     * */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtils.getSubject().logout();
    }

    /*
     * 注册请求
     * @param username 用户名
     * @param password 密码
     * */
    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username"),
                password = request.getParameter("password");
        printWriter(response, userServiceImpl.addUser(username, password));
    }

    /*
     * 返回json给ajax
     * @param obj
     * */
    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
