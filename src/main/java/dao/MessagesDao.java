package dao;

import entity.MessagesEntity;

import java.util.List;

public interface MessagesDao {
    public boolean save(MessagesEntity messagesEntity,String author);
    public List<MessagesEntity> query(String username);
    public boolean read(String username,int sid);
}
