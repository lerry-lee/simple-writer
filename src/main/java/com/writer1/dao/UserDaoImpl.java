package com.writer1.dao;

import com.writer1.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    SqlSession session = null;
    boolean flag;

    @Override
    public boolean queryByUsername(String username) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        Integer u = session.selectOne("queryByUsername", username);
        BaseDao.commitAndClose(session);
        if (u!= null) flag = true;
        return flag;
    }

    @Override
    public boolean add(User user) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        if (session.insert("addUser", user) > 0) flag = true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public boolean queryByUsernameAndPassword(User user) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        Integer u = session.selectOne("queryByUsernameAndPassword", user);
        BaseDao.commitAndClose(session);
        if (u!= null) flag = true;
        return flag;
    }

    @Override
    public void createReflectiveTable(Map<String, String> table) throws IOException {
        session = BaseDao.getSession();
        session.update("createTableReflective", table);
        BaseDao.commitAndClose(session);
    }

    @Override
    public void createMessagesTable(Map<String, String> table) throws IOException {
        session = BaseDao.getSession();
        session.update("createTableMessages", table);
        BaseDao.commitAndClose(session);
    }
}
