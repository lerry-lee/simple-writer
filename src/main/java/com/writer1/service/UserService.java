package com.writer1.service;

import com.writer1.dao.UserDaoImpl;
import com.writer1.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    User user;
    UserDaoImpl userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public int queryByUsername(String username) throws IOException {
        if (userDao.queryByUsername(username)) return 1;
        return 0;
    }

    public int queryByUsernameAndPassword(String username, String password) throws IOException {
        user = new User(username, password);
        if (userDao.queryByUsernameAndPassword(user)) return 1;
        return 0;
    }

    public int addUser(String username, String password) throws IOException {
        user = new User(username, password);
        Map<String, String> t1 = new HashMap<String, String>();
        t1.put("tableName", username + "_reflective");
        Map<String, String> t2 = new HashMap<String, String>();
        t2.put("tableName", username + "_messages");
        if (userDao.add(user)) {
            userDao.createReflectiveTable(t1);
            userDao.createMessagesTable(t2);
            return 1;
        }
        return 0;
    }
}
