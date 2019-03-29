package com.writer1.service.impl;

import com.writer1.bean.Msg;
import com.writer1.entity.Messages;
import com.writer1.mapper.MessagesMapper;
import com.writer1.service.MessagesService;
import com.writer1.utils.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    private MessagesMapper messagesMapper;
    private Map<String, Object> map;

    @Override
    public int save(String commentator, Msg m) {
        map = new HashMap<>();
        map.put("tableName", m.getAuthor() + "_messages");
        map.put("sid", m.getSid());
        map.put("comment", m.getComment());
        String message = commentator + "评论了你的帖子《" + m.getTitle() + "》";
        map.put("message",message);
        if (messagesMapper.add(map) > 0) return 1;
        return 0;
    }

    @Override
    public String query(String username) throws IOException {
        map = new HashMap<>();
        map.put("tableName", username + "_messages");
        List<Messages> list = messagesMapper.query(map);
        return ToJson.toJson(list);
    }

    @Override
    public int read(String username, int id) {
        map = new HashMap<>();
        map.put("tableName", username + "_messages");
        map.put("id", id);
        if (messagesMapper.read(map) > 0) return 1;
        return 0;
    }

    @Override
    public int count(String username) {
        map = new HashMap<>();
        map.put("tableName", username + "_messages");
        return messagesMapper.count(map);
    }

    @Override
    public int readAll(String username) {
        map = new HashMap<>();
        map.put("tableName", username + "_messages");
        if (messagesMapper.readAll(map) > 0) return 1;
        return 0;
    }
}
