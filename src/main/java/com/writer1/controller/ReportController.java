package com.writer1.controller;

import com.writer1.service.impl.ReportServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.writer1.utils.SendHttpPostJson.sendHttpPostJson;

@Controller
public class ReportController {
    @Autowired
    private ReportServiceImpl reportServiceImpl;
    /*
     * 查询当前用户的上次写作存档
     * @param username 当前用户名
     * */
    @RequestMapping("/queryReport")
    public void queryReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        printWriter(response, reportServiceImpl.query(username));
    }
    /*
     * 保存写作编辑
     * @param username 当前用户名
     * @param content 写作内容
     * */
    @RequestMapping("/saveReport")
    public void saveReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username == null) return;
        String content = request.getParameter("content");
        printWriter(response, reportServiceImpl.save(username, content));
    }
    /*
     * 得到反馈
     * @param param_json json参数
     * @param feature 分析类型特征值
     * */
    @RequestMapping("/getFeedback")
    public void getFeedBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param_json = request.getParameter("param_json");
        int feature = Integer.parseInt(request.getParameter("feature"));
        printWriter(response, sendHttpPostJson(param_json, feature));
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
