package com.writer1.service;

import java.io.IOException;

public interface MessagesService {
    public int save(String author, String commentator, int sid, String comment, String title);

    public String query(String username) throws IOException;

    public int read(String username, int id);

    public int count(String username);

    public int readAll(String username);
}
