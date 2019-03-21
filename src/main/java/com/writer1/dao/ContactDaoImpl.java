package com.writer1.dao;

import com.writer1.entity.Contact;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class ContactDaoImpl implements ContactDao {
    SqlSession session = null;
    boolean flag;

    @Override
    public boolean save(Contact contact) throws IOException {
        flag=false;
        session=BaseDao.getSession();
        if(session.update("addContact",contact)>0) flag=true;
        BaseDao.commitAndClose(session);
        return flag;
    }
}
