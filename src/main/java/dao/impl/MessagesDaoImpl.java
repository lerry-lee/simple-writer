package dao.impl;

import dao.BaseDao;
import dao.MessagesDao;
import entity.MessagesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessagesDaoImpl implements MessagesDao {
    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public boolean save(MessagesEntity messagesEntity, String author) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "INSERT INTO " + author + "_messages" + " (sid,message,comment) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, messagesEntity.getSid());
            pst.setString(2, messagesEntity.getMessage());
            pst.setString(3,messagesEntity.getComment());
            int rs = pst.executeUpdate();
            if (rs > 0)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return flag;
    }

    @Override
    public List<MessagesEntity> query(String username) {
        List<MessagesEntity> list = new ArrayList<>();
        conn = BaseDao.getconn();
        String sql = "SELECT message,comment FROM " + username + "_messages" + " WHERE isRead=0";
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                MessagesEntity messagesEntity = new MessagesEntity(rs.getString(1), rs.getString(2));
                list.add(messagesEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }

    @Override
    public boolean read(String username, int sid) {
        boolean flag=false;
        conn=BaseDao.getconn();
        String sql="UPDATE "+username+"_messages"+" SET isRead=1 WHERE sid=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setInt(1,sid);
            int rs=pst.executeUpdate();
            if(rs>0)
                flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return flag;
    }
}
