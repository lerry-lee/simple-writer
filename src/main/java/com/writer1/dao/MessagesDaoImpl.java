package com.writer1.dao;

import com.writer1.entity.Messages;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MessagesDaoImpl implements MessagesDao {
    SqlSession session = null;
    boolean flag;

    @Override
    public boolean save(Map<String, Object> map) throws IOException {
        flag=false;
        session=BaseDao.getSession();
        if(session.insert("addMessages",map)>0) flag=true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public List<Messages> query(Map<String, String> map) throws IOException {
        session=BaseDao.getSession();
        List<Messages> list=session.selectList("queryMessages",map);
        BaseDao.commitAndClose(session);
        return list;
    }
}
