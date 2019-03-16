package com.writer1.service;

import com.writer1.dao.VisitsDaoImpl;

import java.io.IOException;

public class VisitsService {
    VisitsDaoImpl visitsDao;
    public VisitsService(){
        visitsDao=new VisitsDaoImpl();
    }
    public int add(String username, String vdate) throws IOException {
        String sign=username+vdate;
        if(visitsDao.add(sign)) return 1;
        return 0;
    }
    public int queryTotal() throws IOException {
        return visitsDao.query();
    }
}
