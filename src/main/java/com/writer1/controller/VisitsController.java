package com.writer1.controller;

import com.writer1.service.impl.VisitsServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class VisitsController {
    @Autowired
    private VisitsServiceImpl visitsServiceImpl;
    /*
     * 访问量+1
     * @param username 当前用户名
     * @param vdate 访问时间 格式：年-月-日
     * */
    @RequestMapping("/addVisits")
    public void addVisits(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String vdate = df.format(new Date());
        printWriter(response, visitsServiceImpl.add(username, vdate));
    }
    /*
     * 获得总访问量
     * */
    @RequestMapping("/getVisits")
    public void getVisits(HttpServletRequest request, HttpServletResponse response) throws IOException {
        printWriter(response, visitsServiceImpl.queryTotal());
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
