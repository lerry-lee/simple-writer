package com.writer1.service;

import com.writer1.entity.Posts;

import java.io.IOException;

public interface PostsService {
    public int save(Posts p);

    public String queryAll() throws IOException;

    public String queryMy(String author) throws IOException;

    public String fuzzyQuery(String key_words, String category, String author) throws IOException;
}
