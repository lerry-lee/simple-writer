package com.writer1.dao;

import com.writer1.entity.User;

import java.io.IOException;
import java.util.Map;

public interface UserDao {
    public boolean queryByUsername(String username) throws IOException;
    public boolean add(User user) throws IOException;
    public boolean queryByUsernameAndPassword(User user) throws IOException;
    public void createReflectiveTable(Map<String,String> table) throws IOException;
    public void createMessagesTable(Map<String,String> table) throws IOException;
}
