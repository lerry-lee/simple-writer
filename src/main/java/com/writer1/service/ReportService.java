package com.writer1.service;

public interface ReportService {
    public int save(String username, String content);

    public String query(String username);
}
