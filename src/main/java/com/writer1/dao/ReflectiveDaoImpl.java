package com.writer1.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.writer1.entity.Reflective;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReflectiveDaoImpl implements ReflectiveDao {
    SqlSession session = null;
    boolean flag;
    @Getter
    @Setter
    private int total;

    @Override
    public boolean save(Map<String, Object> map) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        if (session.insert("addReflective", map) > 0) flag = true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public boolean delete(Map<String, Object> map) throws IOException {
        flag = false;
        session = BaseDao.getSession();
        if (session.delete("deleteFromReflective", map) > 0) flag = true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public List<Reflective> queryTitle(Map<String, Object> map, int offset, int rows) throws IOException {
        session = BaseDao.getSession();
        PageHelper.offsetPage(offset, rows);
        List<Reflective> list = session.selectList("queryReflectiveTitle", map);
        BaseDao.commitAndClose(session);
        setTotal((int) new PageInfo<>(list).getTotal());
        return list;
    }

    @Override
    public List<Reflective> fuzzyQuery(Map<String, Object> map, int offset, int rows) throws IOException {
        session = BaseDao.getSession();
        PageHelper.offsetPage(offset, rows);
        List<Reflective> list = session.selectList("fuzzyQueryReflective", map);
        BaseDao.commitAndClose(session);
        setTotal((int) new PageInfo<>(list).getTotal());
        return list;
    }

    @Override
    public List<Reflective> queryScore(Map<String, String> map) throws IOException {
        session = BaseDao.getSession();
        List<Reflective> list = session.selectList("queryReflectiveScore", map);
        BaseDao.commitAndClose(session);
        return list;
    }
}
