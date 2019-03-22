package com.writer1.service.impl;

import com.writer1.entity.Posts;
import com.writer1.mapper.PostsMapper;
import com.writer1.service.PostsService;
import com.writer1.utils.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostsServiceImpl implements PostsService {
    private Posts posts;
    private List<Posts> list;
    private Map<String, String> map_;
    @Autowired
    private PostsMapper postsMapper;

    @Override
    public int save(String author, String sdate, String category, String content, String title) {
        posts = new Posts(author, sdate, category, content, title);
        if (postsMapper.add(posts) > 0) return 1;
        return 0;
    }

    @Override
    public String queryAll() throws IOException {
        list = new ArrayList<>();
        list = postsMapper.queryAll();
        return ToJson.toJson(list);
    }

    @Override
    public String queryMy(String author) throws IOException {
        list = new ArrayList<>();
        list = postsMapper.queryMy(author);
        return ToJson.toJson(list);
    }

    @Override
    public String queryByCategory(String category, String author) throws IOException {
        map_ = new HashMap<>();
        map_.put("category", category);
        map_.put("author", author);
        list = new ArrayList<>();
        list = postsMapper.queryByCategory(map_);
        return ToJson.toJson(list);
    }

    @Override
    public String fuzzyQuery(String key_words, String category, String author) throws IOException {
        map_ = new HashMap<>();
        map_.put("key_words", key_words);
        map_.put("category", category);
        map_.put("author", author);
        list = new ArrayList<>();
        list = postsMapper.fuzzyQuery(map_);
        return ToJson.toJson(list);
    }
}
