package com.writer1.controller;

import com.writer1.service.impl.ContactServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;
    /*
     * 保存该用户的建议
     * @param username 登陆账户的用户名
     * @param name 用户别名
     * @param email 邮箱地址
     * @param comments 建议或意见内容
     * */
    @RequestMapping("/saveContact")
    public void saveContact(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String comments=request.getParameter("comments");
        printWriter(response,contactService.save(username,name,email,comments));
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
