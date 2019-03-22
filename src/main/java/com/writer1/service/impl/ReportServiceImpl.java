package com.writer1.service.impl;

import com.writer1.entity.Report;
import com.writer1.mapper.ReportMapper;
import com.writer1.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private Report report;
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public int save(String username, String content) {
        report = new Report(username, content);
        if (reportMapper.insertOrUpdate(report) > 0) return 1;
        return 0;
    }

    @Override
    public String query(String username) {
        return reportMapper.query(username);
    }
}
