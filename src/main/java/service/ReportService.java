package service;

import dao.impl.ReportDaoImpl;

public class ReportService {
    public static boolean saveReport(String username,String content){
        ReportDaoImpl r=new ReportDaoImpl();
        return r.save(username,content);
    }
    public static String queryContent(String username) {
        ReportDaoImpl r=new ReportDaoImpl();
        return r.query(username);
    }
}
