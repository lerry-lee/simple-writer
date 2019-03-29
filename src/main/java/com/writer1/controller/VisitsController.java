package com.writer1.controller;

import com.writer1.service.impl.VisitsServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author lerry
 * @style RESTful
 * */

@Controller
public class VisitsController {
    @Autowired
    private VisitsServiceImpl visitsServiceImpl;

    /*
     * 单个用户每天的访问只记一次
     * @return int
     * */
    @RequestMapping(value = "/visits", method = RequestMethod.POST)
    public @ResponseBody
    int addVisits() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String vdate = df.format(new Date());
        return visitsServiceImpl.add(username, vdate);
    }

    /*
     * 获取总访问量
     * @return int
     * */
    @RequestMapping(value = "/visits", method = RequestMethod.GET)
    public @ResponseBody
    int getVisits() {
        return visitsServiceImpl.queryTotal();
    }

}
