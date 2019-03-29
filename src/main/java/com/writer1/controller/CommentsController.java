package com.writer1.controller;

import com.writer1.bean.Cmts;
import com.writer1.service.impl.CommentsServiceImpl;
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
public class CommentsController {
    @Autowired
    private CommentsServiceImpl commentsService;

    /*
     * 保存一次评论
     * @method POST
     * @param Cmts{sid,comment,niming}
     * @return int
     * */
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public @ResponseBody
    int
    saveComments(@RequestBody Cmts c) {
        String commentator = c.getNiming() == 1 ? "匿名用户" : (String) SecurityUtils.getSubject().getPrincipal();
        if (commentator == null) return 0;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String cdate = df.format(new Date());
        return commentsService.save(c.getSid(), c.getComment(), cdate, commentator);
    }

    /*
     * 获取所有评论
     * @method GET
     * @param sid 帖子的id
     * @return String
     * */
    @RequestMapping(value = "/comments", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String queryComments(@RequestParam("sid") String sid_) throws IOException {
        int sid = Integer.parseInt(sid_);
        return commentsService.query(sid);
    }

}
