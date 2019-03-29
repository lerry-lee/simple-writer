package com.writer1.controller;

import com.writer1.entity.User;
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
import org.springframework.web.bind.annotation.*;

/*
 * @author lerry
 * @style RESTful
 * */

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /*
     * 检查用户名是否已存在
     * @method GET
     * @param username
     * @return int
     * */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public @ResponseBody
    int checkUsername(@RequestParam("username") String username) {
        return userServiceImpl.queryByUsername(username);
    }

    /*
     * 注册请求
     * @method PUT
     * @param User
     * @return int
     * */
    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public @ResponseBody
    int register(@RequestBody User u) {
        String username = u.getUsername();
        String password = u.getPassword();
        return userServiceImpl.addUser(username, password);
    }

    /*
     * 获得登录状态
     * @method GET
     * @return String
     * */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    String getUsername() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        logger.info("当前用户为{}", username);
        return username;
    }

    /*
     * 登陆请求
     * @method POST
     * @param User
     * @return int
     * */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    int login(@RequestBody User u) {

        String username = u.getUsername(),
                password = u.getPassword();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            logger.info(username + "已登录 ");
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return 1;
        } catch (AuthenticationException e) {
            return 0;
        }
    }

    /*
     * 退出登录
     * @method GET
     * */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public @ResponseBody
    void logout() {
        SecurityUtils.getSubject().logout();
    }

}
