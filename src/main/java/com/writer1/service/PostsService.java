package com.writer1.service;

import com.writer1.dao.PostsDaoImpl;
import com.writer1.entity.Posts;
import com.writer1.utils.ToJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostsService {
    Posts posts;
    List<Posts> list;
    Map<String, Object> map;
    Map<String,String> map_;
    PostsDaoImpl postsDao;

    public PostsService() {
        postsDao = new PostsDaoImpl();
        map = new HashMap<>();
    }

    public int save(String author, String sdate, String category, String content, String title) throws IOException {
        posts = new Posts(author, sdate, category, content, title);
        if (postsDao.save(posts)) return 1;
        return 0;
    }

    public String queryAll() throws IOException {
        list = postsDao.queryAll();
        return ToJson.toJson(list);
    }

    public String queryMy(String author) throws IOException {
        list = postsDao.queryMy(author);
        return ToJson.toJson(list);
    }
    public boolean addComments(int sid) throws IOException {
        if(postsDao.addComments(sid)) return true;
        return false;
    }
    public String queryByCategory(String category,String author) throws IOException {
        map_=new HashMap<>();
        map_.put("category",category);
        map_.put("author",author);
        list=postsDao.queryByCategory(map_);
        return ToJson.toJson(list);
    }
    public String fuzzyQuery(String key_words,String category,String author) throws IOException {
        map_=new HashMap<>();
        map_.put("key_words",key_words);
        map_.put("category",category);
        map_.put("author",author);
        list=postsDao.fuzzyQuery(map_);
        return ToJson.toJson(list);
    }
}
