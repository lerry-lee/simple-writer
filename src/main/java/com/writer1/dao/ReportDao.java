package com.writer1.dao;

import com.writer1.entity.Report;

import java.io.IOException;

public interface ReportDao {
    public boolean insertOrUpdate(Report report) throws IOException;
    public String queryByUsername(String username) throws IOException;
}
