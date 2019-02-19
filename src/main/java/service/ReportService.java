package service;

import dao.impl.ReportDaoImpl;
import entity.ReportEntity;

public class ReportService {
    public static boolean saveReport(ReportEntity report){
        ReportDaoImpl r=new ReportDaoImpl();
        return r.save(report);
    }
    public static String queryContent(String username) {
        ReportDaoImpl r=new ReportDaoImpl();
        return r.query(username);
    }
}
