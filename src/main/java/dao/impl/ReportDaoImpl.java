package dao.impl;

import dao.BaseDao;
import dao.ReportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDaoImpl implements ReportDao {
    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public boolean save(String username, String content) {
        conn= BaseDao.getconn();
        String sql="INSERT INTO Report (username,content) VALUES (?,?)" +
                "ON DUPLICATE KEY UPDATE content = ? ";
        boolean flag=false;
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2, content);
            pst.setString(3,content);
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

    @Override
    public String query(String username) {
        conn=BaseDao.getconn();
        String sql="SELECT content FROM Report WHERE username = ?";
        String content="";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                content=rs.getString("content");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return content;
    }
}
