package com.writer1.mapper;

import com.writer1.entity.Report;

import java.io.IOException;

public interface ReportMapper {
    public int insertOrUpdate(Report report);
    public String query(String username);
}
