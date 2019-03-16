package com.writer1.dao;

import com.writer1.entity.Messages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MessagesDao {
    public boolean save(Map<String,Object> map) throws IOException;
    public List<Messages> query(Map<String,String> map) throws IOException;
}
