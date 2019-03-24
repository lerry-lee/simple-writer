package com.writer1.service;

public interface UserService {
    public int queryByUsername(String username);
    public int queryByUsernameAndPassword(String username, String password);
    public String getPassword(String username);
    public int addUser(String username, String password);
}
