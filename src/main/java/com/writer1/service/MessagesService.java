package com.writer1.service;

import com.writer1.dao.MessagesDaoImpl;
import com.writer1.entity.Messages;
import com.writer1.utils.ToJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesService {
    MessagesDaoImpl messagesDao;
    Map<String,Object> map;
    public MessagesService(){
        messagesDao=new MessagesDaoImpl();
        map=new HashMap<>();
    }
    public int save(String author,String commentator,int sid,String comment,String title) throws IOException {
        map.put("tableName",author+"_messages");
        map.put("sid",sid);
        map.put("comment",comment);
        String message=commentator+"评论了你的帖子《"+title+"》";
        map.put("message",message);
        if(messagesDao.save(map)) return 1;
        return 0;
    }
    public String query(String username) throws IOException {
        map.put("tableName",username+"_messages");
        List<Messages> list=messagesDao.query(map);
        return ToJson.toJson(list);
    }
    public int read(String username,int id) throws IOException {
        map.put("tableName",username+"_messages");
        map.put("id",id);
        if(messagesDao.read(map)) return 1;
        return 0;
    }
    public int count(String username) throws IOException {
        map.put("tableName",username+"_messages");
        return messagesDao.count(map);
    }
    public int readAll(String username) throws IOException {
        map.put("tableName",username+"_messages");
        if(messagesDao.readAll(map)) return 1;
        return 0;
    }
}
