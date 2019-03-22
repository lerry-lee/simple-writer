package com.writer1.service.impl;

import com.writer1.entity.User;
import com.writer1.mapper.UserMapper;
import com.writer1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private User user;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int queryByUsername(String username) {
        user = new User();
        user.setUsername(username);
        if (userMapper.queryByU(username) != null) return 1;
        return 0;
    }

    @Override
    public int queryByUsernameAndPassword(String username, String password) {
        user = new User(username, password);
        if (userMapper.queryByUAndP(user) != null) return 1;
        return 0;
    }

    @Override
    public int addUser(String username, String password) {
        user = new User(username, password);
        Map<String, String> t1 = new HashMap<String, String>();
        t1.put("tableName", username + "_reflective");
        Map<String, String> t2 = new HashMap<String, String>();
        t2.put("tableName", username + "_messages");
        if (userMapper.add(user) > 0) {
            userMapper.createTableR(t1);
            userMapper.createTableM(t2);
            return 1;
        }
        return 0;
    }
}
