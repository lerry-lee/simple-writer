package com.writer1.dao;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class VisitsDaoImpl implements VisitsDao {
    SqlSession session=null;
    boolean flag;

    @Override
    public boolean add(String sign) throws IOException {
        flag=false;
        session=BaseDao.getSession();
        if(session.insert("addVisits",sign)>0) flag=true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public int query() throws IOException {
        session=BaseDao.getSession();
        int total= session.selectOne("queryTotalVisits");
        BaseDao.commitAndClose(session);
        return total;
    }
}
