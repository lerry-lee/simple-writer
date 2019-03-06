package dao.impl;

import dao.BaseDao;
import dao.ShareDao;
import entity.ShareEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShareDaoImpl implements ShareDao {
    Connection conn = null;
    PreparedStatement pst = null;
    @Getter@Setter
    private int total;
    @Override
    public boolean save(ShareEntity share) {
        boolean flag=false;
        conn= BaseDao.getconn();
        String sql="INSERT INTO share (author,sdate,category,title,content) VALUES(?,?,?,?,?)";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,share.getAuthor());
            pst.setString(2,share.getSdate());
            pst.setString(3,share.getCategory());
            pst.setString(4,share.getTitle());
            pst.setString(5,share.getContent());
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
    public List<ShareEntity> query(int offset,int rows) {
        List<ShareEntity> list=new ArrayList<>();
        conn=BaseDao.getconn();
        String sql="SELECT SQL_CALC_FOUND_ROWS id,sdate,category,content,title,totalComments,author FROM share LIMIT ?,?";
        String sql_="SELECT FOUND_ROWS()";
        try{
            pst=conn.prepareStatement(sql);
            pst.setInt(1,offset);
            pst.setInt(2,rows);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                ShareEntity shareEntity=new ShareEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
                list.add(shareEntity);
            }
            pst=conn.prepareStatement(sql_);
            ResultSet rs_=pst.executeQuery();
            while(rs_.next())
                setTotal(rs_.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return list;
    }

    @Override
    public List<ShareEntity> queryMy(String username,int offset, int rows) {
        List<ShareEntity> list=new ArrayList<>();
        conn=BaseDao.getconn();
        String sql="SELECT SQL_CALC_FOUND_ROWS id,sdate,category,content,title,totalComments FROM share WHERE author =? LIMIT ?,?";
        String sql_="SELECT FOUND_ROWS()";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setInt(2,offset);
            pst.setInt(3,rows);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                ShareEntity shareEntity=new ShareEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                list.add(shareEntity);
            }
            pst=conn.prepareStatement(sql_);
            ResultSet rs_=pst.executeQuery();
            while(rs_.next())
                setTotal(rs_.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return list;
    }
}
