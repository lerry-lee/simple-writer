package com.writer1.controller;

import com.writer1.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.writer1.utils.SendHttpPostJson.sendHttpPostJson;

@Controller
public class ReportController {
    @RequestMapping("/queryReport")
    public void queryReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        printWriter(response, new ReportService().query(username));
    }

    @RequestMapping("/saveReport")
    public void saveReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) return;
        String content = request.getParameter("content");
        printWriter(response, new ReportService().save(username, content));
    }

    @RequestMapping("/getFeedback")
    public void getFeedBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param_json = request.getParameter("param_json");
        int feature = Integer.parseInt(request.getParameter("feature"));
        printWriter(response, sendHttpPostJson(param_json, feature));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}
