package com.writer1.controller;

import com.writer1.entity.Report;
import com.writer1.service.impl.ReportServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.writer1.utils.SendHttpPostJson.sendHttpPostJson;

/*
 * @author lerry
 * @style RESTful
 * */

@Controller
public class ReportController {
    @Autowired
    private ReportServiceImpl reportServiceImpl;

    /*
     * 查询当前用户的上次写作存档
     * @method GET
     * @return String
     * */
    @RequestMapping(value = "/report", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String
    queryReport() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return reportServiceImpl.query(username);
    }

    /*
     * 保存写作编辑
     * @method PUT
     * @param content
     * @return int
     * */
    @RequestMapping(value = "/report", method = RequestMethod.PUT)
    public @ResponseBody
    int saveReport(@RequestBody Report r) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username == null) return 0;
        r.setUsername(username);
        return reportServiceImpl.save(r);
    }

    /*
     * 得到反馈
     * @method POST
     * @param param_json json参数
     * @param feature 分析类型特征值
     * */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public void getFeedBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param_json = request.getParameter("param_json");
        int feature = Integer.parseInt(request.getParameter("feature"));
        PrintWriter out = response.getWriter();
        out.print(sendHttpPostJson(param_json, feature));
        out.close();
    }

}
