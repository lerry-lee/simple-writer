package com.writer1.dao;

import com.writer1.entity.Comments;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CommentsDaoImpl implements CommentsDao {
    SqlSession session = null;
    boolean flag;

    @Override
    public boolean save(Comments comments) throws IOException {
        flag=false;
        session= BaseDao.getSession();
        if(session.insert("addComments",comments)>0) flag=true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public List<Comments> query(int sid) throws IOException {
        session=BaseDao.getSession();
        List<Comments> list=session.selectList("queryComments",sid);
        BaseDao.commitAndClose(session);
        return list;
    }
}
