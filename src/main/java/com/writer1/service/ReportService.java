package com.writer1.service;

import com.writer1.dao.ReportDaoImpl;
import com.writer1.entity.Report;

import java.io.IOException;


public class ReportService {
    Report report;
    ReportDaoImpl reportDao;

    public ReportService() {
        reportDao = new ReportDaoImpl();
    }

    public int save(String username, String content) throws IOException {
        report = new Report(username, content);
        if (reportDao.insertOrUpdate(report)) return 1;
        return 0;
    }

    public String query(String username) throws IOException {
        return reportDao.queryByUsername(username);
    }
}
