package com.writer1.mapper;

import com.writer1.entity.Posts;

import java.util.List;
import java.util.Map;

public interface PostsMapper {
    public int add(Posts posts);

    public List<Posts> queryAll();

    public List<Posts> queryMy(String author);

    public int addComments(int sid);

    public List<Posts> fuzzyQuery(Map<String, String> map);

    public List<Posts> queryByCategory(Map<String, String> category);
}
