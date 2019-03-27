package com.writer1.service;

import java.io.IOException;

public interface PostsService {
    public int save(String author, String sdate, String category, String content, String title);

    public String queryAll() throws IOException;

    public String queryMy(String author) throws IOException;

    public String queryByCategory(String category, String author,String key_words) throws IOException;

    public String fuzzyQuery(String key_words, String category, String author) throws IOException;
}
