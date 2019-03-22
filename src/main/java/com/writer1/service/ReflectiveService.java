package com.writer1.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ReflectiveService {
    public int add(String username, String title, String content, int self, int comparison, int summary, int automary, String sdate);

    public String queryTitle(String username, int offset, int rows) throws JsonProcessingException;

    public String fuzzyQuery(String username, String title, String start_date, String end_date, int offset, int rows) throws JsonProcessingException;

    public int delete(String username, int id);

    public String queryScore(String username) throws JsonProcessingException;

}
