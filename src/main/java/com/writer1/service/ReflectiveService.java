package com.writer1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.writer1.entity.Reflective;

public interface ReflectiveService {
    public int add(String username, Reflective r);

    public String queryTitle(String username, int offset, int rows) throws JsonProcessingException;

    public String fuzzyQuery(String username, String title, String start_date, String end_date, int offset, int rows) throws JsonProcessingException;

    public int delete(String username, int id);

    public String queryScore(String username) throws JsonProcessingException;

}
