package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public boolean login_check(UserEntity user) {
        conn = BaseDao.getconn();
        String sql = "SELECT id FROM User WHERE username = ? and password = ?";
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return flag;
    }

    @Override
    public boolean query_with_username(String username) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "SELECT id FROM User WHERE username = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return flag;
    }

    @Override
    public boolean save(UserEntity user) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "INSERT INTO User (username,password) values (?,?)";
        String sql_create = "CREATE TABLE IF NOT EXISTS " + user.getUsername() + "_reflective" +
                " (id int primary key auto_increment, title varchar(16), content text, self int, comparison int, summary int, automatic int, sdate char(19))DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";
        String sql_createMsg="CREATE TABLE IF NOT EXISTS "+user.getUsername()+"_messages"+" (id int primary key auto_increment, sid int, message varchar(100), isRead int(1))DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            if (pst.executeUpdate() > 0)
                flag = true;
            pst=conn.prepareStatement(sql_create);
            pst.executeUpdate();
            pst=conn.prepareStatement(sql_createMsg);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return flag;
    }

    @Override
    public boolean update(UserEntity user, String password_new) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "UPDATE User SET password = ? WHERE username = ? AND password = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, password_new);
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
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
}
