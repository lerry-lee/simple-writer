package com.writer1.service;

import com.writer1.bean.Msg;

import java.io.IOException;

public interface MessagesService {
    public int save(String commentator, Msg m);

    public String query(String username) throws IOException;

    public int read(String username, int id);

    public int count(String username);

    public int readAll(String username);
}
