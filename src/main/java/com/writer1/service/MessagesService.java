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
    public MessagesService(){
        messagesDao=new MessagesDaoImpl();
    }
    public int save(String author,String commentator,int sid,String comment,String title) throws IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("tableName",author+"_messages");
        map.put("sid",sid);
        map.put("comment",comment);
        String message=commentator+"评论了你的帖子《"+title+"》";
        map.put("message",message);
        if(messagesDao.save(map)) return 1;
        return 0;
    }
    public String query(String username) throws IOException {
        Map<String,String> map=new HashMap<>();
        map.put("tableName",username+"_messages");
        List<Messages> list=messagesDao.query(map);
        return ToJson.toJson(list);
    }
}
