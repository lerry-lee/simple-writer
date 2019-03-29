package com.writer1.controller;

import com.writer1.bean.Msg;
import com.writer1.entity.Messages;
import com.writer1.service.impl.MessagesServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/*
 * @author lerry
 * @style RESTful
 * */

@Controller
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;

    /*
     * 获取未读消息数量
     * @method GET
     * @param username 当前用户名
     * @return int
     * */
    @RequestMapping(value = "/messages/count", method = RequestMethod.GET)
    public @ResponseBody
    int countMessages() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return messagesService.count(username);
    }

    /*
     * 保存一次消息
     * @method POST
     * @param Messages
     * @return int
     * */
    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public @ResponseBody
    int
    saveMessages(@RequestBody Msg m) throws UnsupportedEncodingException {
        String commentator = (String) SecurityUtils.getSubject().getPrincipal();
        m.setTitle(URLDecoder.decode(m.getTitle(), "UTF-8"));
        return messagesService.save(commentator, m);
    }

    /*
     * 列出所有消息
     * @method GET
     * @param username 当前用户名
     * @return String
     * */
    @RequestMapping(value = "/messages", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String queryMessages() throws IOException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return messagesService.query(username);
    }

    /*
     * 已读一条消息
     * @method PUT
     * @param Messages.id
     * @return int
     * */
    @RequestMapping(value = "/messages", method = RequestMethod.PUT)
    public @ResponseBody
    int readMessages(@RequestBody Msg m) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return messagesService.read(username, m.getId());
    }

    /*
     * 已读所有消息
     * @method PUT
     * @param username 当前用户名
     * @return int
     * */
    @RequestMapping(value = "/messages/all", method = RequestMethod.PUT)
    public @ResponseBody
    int readAllMessages() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return messagesService.readAll(username);
    }

}
