package com.writer1.controller;

import com.writer1.entity.Posts;
import com.writer1.service.impl.PostsServiceImpl;
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
public class PostsController {
    @Autowired
    private PostsServiceImpl postsService;

    /*
     * 保存发布的帖子
     * @method POST
     * @param Posts
     * @return int
     * */
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public @ResponseBody
    int
    savePosts(@RequestBody Posts p) {
        String author = (String) SecurityUtils.getSubject().getPrincipal();
        if (author == null) return 0;
        p.setAuthor(author);
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        p.setSdate(df.format(new Date()));
        return postsService.save(p);
    }

    /*
     * 获取所有帖子
     * @method GET
     * @return String
     * */
    @RequestMapping(value = "/posts", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String queryAllPosts() throws IOException {
        return postsService.queryAll();
    }

    /*
     * 获取当前用户发布的帖子
     * @method GET
     * @param author 当前用户名
     * @return String
     * */
    @RequestMapping(value = "/posts/my", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String queryMyPosts() throws IOException {
        String author = (String) SecurityUtils.getSubject().getPrincipal();
        return postsService.queryMy(author);
    }

    /*
     * 模糊查询
     * @method GET
     * @param key_words 标题/正文中的关键词
     * @param category 帖子类型
     * @param author 帖子的作者
     * @return String
     * */
    @RequestMapping(value = "/posts/fuzzy", method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    String fuzzyQueryPosts(@RequestParam("category") String category, @RequestParam("author") String author, @RequestParam("key_words") String kw) throws IOException {
        if (author.equals("My"))
            author = (String) SecurityUtils.getSubject().getPrincipal();
        return postsService.fuzzyQuery(kw, category, author);
    }

}
