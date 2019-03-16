package com.writer1.dao;

import com.writer1.entity.Report;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class ReportDaoImpl implements ReportDao {
    SqlSession session=null;
    boolean flag;
    @Override
    public boolean insertOrUpdate(Report report) throws IOException {
        flag=false;
        session=BaseDao.getSession();
        if(session.insert("insertOrUpdate",report)>0) flag=true;
        BaseDao.commitAndClose(session);
        return flag;
    }

    @Override
    public String queryByUsername(String username) throws IOException {
        session=BaseDao.getSession();
        String rst=session.selectOne("queryReportByUsername",username);
        BaseDao.commitAndClose(session);
        return rst;
    }
}
