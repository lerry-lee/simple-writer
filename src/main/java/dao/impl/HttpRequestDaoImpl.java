package dao.impl;

import dao.BaseDao;
import dao.HttpRequestDao;
import entity.HttpRequestInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HttpRequestDaoImpl implements HttpRequestDao {

    Connection conn=null;
    PreparedStatement pst=null;
    @Override
    public void insert(HttpRequestInfo httpRequestInfo) {
        conn= BaseDao.getconn();
        String sql="INSERT INTO HttpRequestInfo(Date,Url,Method,Ip,Param,Status,TimeConsuming) VALUES(?,?,?,?,?,?,?)";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, httpRequestInfo.getDate());
            pst.setString(2, httpRequestInfo.getUrl());
            pst.setString(3, httpRequestInfo.getMethod());
            pst.setString(4, httpRequestInfo.getIp());
            pst.setString(5, httpRequestInfo.getParam());
            pst.setInt(6, httpRequestInfo.getStatus());
            pst.setLong(7, httpRequestInfo.getTimeConsuming());

            int rs=pst.executeUpdate();
            if(rs>0)
                System.out.println("插入成功\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }

    }
}
