package com.writer1.dao;

import com.writer1.entity.Reflective;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ReflectiveDao {
    public boolean save(Map<String,Object> map) throws IOException;
    public boolean delete(Map<String,Object> map) throws IOException;
    public List<Reflective> queryTitle(Map<String,Object> map,int offset,int rows) throws IOException;
    public List<Reflective> fuzzyQuery(Map<String,Object> map,int offset,int rows) throws IOException;
    public List<Reflective> queryScore(Map<String,String> map) throws IOException;
}
