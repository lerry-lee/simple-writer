package com.writer1.dao;

import com.writer1.entity.Posts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PostsDao {
    public boolean save(Posts posts) throws IOException;
    public List<Posts> queryAll() throws IOException;
    public List<Posts> queryMy(String author) throws IOException;
    public boolean addComments(int sid) throws IOException;
    public List<Posts> fuzzyQuery(Map<String,String> map) throws IOException;
    public List<Posts> queryByCategory(Map<String,String> category) throws IOException;
}
