package com.writer1.mapper;

import com.writer1.entity.User;

import java.util.Map;

public interface UserMapper {
    public User queryByU(String username);

    public int add(User user);

    public User queryByUAndP(User user);

    public void createTableR(Map<String, String> table);

    public void createTableM(Map<String, String> table);

}
