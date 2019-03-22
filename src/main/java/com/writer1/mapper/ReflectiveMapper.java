package com.writer1.mapper;

import com.writer1.entity.Reflective;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ReflectiveMapper {
    public int add(Map<String,Object> map) ;
    public int delete(Map<String,Object> map) ;
    public List<Reflective> queryTitle(Map<String,Object> map) ;
    public List<Reflective> fuzzyQuery(Map<String,Object> map) ;
    public List<Reflective> queryScore(Map<String,String> map);
}
