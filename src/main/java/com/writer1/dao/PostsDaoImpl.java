package com.writer1.dao;

import com.writer1.entity.Posts;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PostsDaoImpl implements PostsDao {
    SqlSession session = null;
    boolean flag;

    @Override
    public boolean save(Posts posts) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        if (session.insert("addPosts", posts) > 0) flag = true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public List<Posts> queryAll() throws IOException {
        session = BaseDao.getSession();
        List<Posts> list = session.selectList("queryAllPosts");
        BaseDao.commitAndClose(session);
        return list;
    }

    @Override
    public List<Posts> queryMy(String author) throws IOException {
        session = BaseDao.getSession();
        List<Posts> list = session.selectList("queryMyPosts", author);
        BaseDao.commitAndClose(session);
        return list;
    }

    @Override
    public boolean addComments(int sid) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        if (session.update("addTotalComments", sid) > 0) flag = true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public List<Posts> fuzzyQuery(Map<String, String> map) throws IOException {
        session = BaseDao.getSession();
        List<Posts> list = session.selectList("fuzzyQueryPosts", map);
        BaseDao.commitAndClose(session);
        return list;
    }

    @Override
    public List<Posts> queryByCategory(Map<String, String> category) throws IOException {
        session = BaseDao.getSession();
        List<Posts> list = session.selectList("queryByCategory", category);
        BaseDao.commitAndClose(session);
        return list;
    }
}
