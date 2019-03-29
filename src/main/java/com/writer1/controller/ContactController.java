package com.writer1.controller;

import com.writer1.entity.Contact;
import com.writer1.service.impl.ContactServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author lerry
 * @style RESTful
 * */

@Controller
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;

    /*
     * 保存该用户的建议
     * @method POST
     * @param Contact
     * @return int
     * */
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public @ResponseBody
    int
    saveContact(@RequestBody Contact c) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        c.setUsername(username);
        return contactService.save(c);
    }

}
