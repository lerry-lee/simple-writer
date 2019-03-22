package com.writer1.mapper;

import com.writer1.entity.Messages;

import java.util.List;
import java.util.Map;

public interface MessagesMapper {
    public int add(Map<String, Object> map);

    public List<Messages> query(Map<String, Object> map);

    public int read(Map<String, Object> map);

    public int readAll(Map<String, Object> map);

    public int count(Map<String, Object> map);
}
