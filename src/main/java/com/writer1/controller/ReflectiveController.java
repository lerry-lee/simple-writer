package com.writer1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.writer1.entity.Reflective;
import com.writer1.service.impl.ReflectiveServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author lerry
 * @style RESTful
 * */

@Controller
public class ReflectiveController {
    @Autowired
    private ReflectiveServiceImpl reflectiveService;

    /*
     * 保存一次写作版本
     * @method POST
     * @param Reflective
     * @return int
     * */
    @RequestMapping(value = "/reflective", method = RequestMethod.POST)
    public @ResponseBody
    int saveReflective(@RequestBody Reflective r) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username == null) return 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        r.setSdate(df.format(new Date()));
        return reflectiveService.add(username, r);
    }

    /*
     * 获取所有写作版本 展示标题
     * @method GET
     * @param username 当前用户名
     * @param page 页数（第几页）
     * @param limit 行数（展示多少行数据）
     * @return String
     * */
    @RequestMapping(value = "/reflective/title", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String getTitle(@RequestParam("page") String page_, @RequestParam("limit") String limit) throws JsonProcessingException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int page = Integer.parseInt(page_);
        int rows = Integer.parseInt(limit);
        int offset = (page - 1) * rows;
        return reflectiveService.queryTitle(username, offset, rows);
    }

    /*
     * 获取所有写作版本 展示评分
     * @method GET
     * @param username 当前用户名
     * @return String
     * */
    @RequestMapping(value = "/reflective/score", method = RequestMethod.GET)
    public @ResponseBody
    String getScore() throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return reflectiveService.queryScore(username);
    }

    /*
     * 模糊查询
     * @method GET
     * @param username 当前用户名
     * @param title 标题
     * @param start_date 起始时间
     * @param end_date 结束时间
     * @param page 页数（第几页）
     * @param limit 行数（展示多少行数据）
     * @return String
     * */
    @RequestMapping(value = "/reflective/fuzzy", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String fuzzyQueryReflective(@RequestParam("title") String title, @RequestParam("start_date") String start, @RequestParam("end_date") String end, @RequestParam("page") String page_, @RequestParam("limit") String limit) throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int page = Integer.parseInt(page_);
        int rows = Integer.parseInt(limit);
        int offset = (page - 1) * rows;
        return reflectiveService.fuzzyQuery(username, title, start, end, offset, rows);
    }

    /*
     * 删除一次写作版本
     * @method GET
     * @param username 当前用户名
     * @param id 写作版本id
     * @return intr
     * */
    @RequestMapping(value = "/reflective", method = RequestMethod.DELETE)
    public @ResponseBody
    int deleteFromReflective(@RequestParam("id") String id_) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int id = Integer.parseInt(id_);
        return reflectiveService.delete(username, id);
    }

}
