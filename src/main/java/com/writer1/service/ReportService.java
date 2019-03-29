package com.writer1.service;

import com.writer1.entity.Report;

public interface ReportService {
    public int save(Report r);

    public String query(String username);
}
