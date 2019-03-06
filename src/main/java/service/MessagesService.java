package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.MessagesDaoImpl;
import entity.MessagesEntity;
import utils.ToJson;

import java.util.List;

public class MessagesService {
    public static boolean save(int sid, String title, String commentator, String author,String comment) {
        String message = commentator + "评论了你的帖子《" + title + "》";
        MessagesEntity messagesEntity = new MessagesEntity(sid, message,comment);
        MessagesDaoImpl messagesDao = new MessagesDaoImpl();
        return messagesDao.save(messagesEntity, author);
    }

    public static String query(String username) {
        MessagesDaoImpl messagesDao = new MessagesDaoImpl();
        List<MessagesEntity> list = messagesDao.query(username);
        String json = null;
        try {
            json = ToJson.toJson(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static boolean read(String username,int sid){
        MessagesDaoImpl messagesDao=new MessagesDaoImpl();
        return messagesDao.read(username,sid);
    }
}
