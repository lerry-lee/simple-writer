package dao.impl;

import dao.BaseDao;
import dao.HttpRequestInfoDao;
import entity.HttpRequestInfoEntity;
import entity.HttpRequestTimesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestInfoDaoImpl implements HttpRequestInfoDao {

    Connection conn=null;
    PreparedStatement pst=null;
    @Override
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity) {
        conn= BaseDao.getconn();
        String sql="INSERT INTO HttpRequestInfo(date,url,param,method,ip,status,timeConsuming) VALUES(?,?,?,?,?,?,?)";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, httpRequestInfoEntity.getDate());
            pst.setString(2, httpRequestInfoEntity.getUrl());
            pst.setString(3, httpRequestInfoEntity.getParam());
            pst.setString(4, httpRequestInfoEntity.getMethod());
            pst.setString(5, httpRequestInfoEntity.getIp());
            pst.setInt(6, httpRequestInfoEntity.getStatus());
            pst.setLong(7, httpRequestInfoEntity.getTimeConsuming());

            int rs=pst.executeUpdate();
           /* if(rs>0)
                System.out.println("HttpRequestInfo表插入成功\n");*/
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }

    }

    @Override
    public List<HttpRequestInfoEntity> query() {
        conn=BaseDao.getconn();
        String sql="SELECT id,date,url,param,method,ip,status,timeConsuming FROM HttpRequestInfo";
        List<HttpRequestInfoEntity> list=new ArrayList<>();
        try{
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String date=rs.getString(2);
                String url=rs.getString(3);
                String param=rs.getString(4);
                String method=rs.getString(5);
                String ip=rs.getString(6);
                Integer status=rs.getInt(7);
                Long timeConsuming=rs.getLong(8);
                HttpRequestInfoEntity httpRequestInfoEntity=new HttpRequestInfoEntity(id,date,url,method,ip,param,status,timeConsuming);

                list.add(httpRequestInfoEntity);
//                System.out.println("HttpRequestInfo表查询成功\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return list;
    }

    @Override
    public List<HttpRequestTimesEntity> queryCount() {
        conn=BaseDao.getconn();
        String sql="SELECT url,COUNT(*) AS count from HttpRequestInfo GROUP BY url ORDER BY count DESC";
        List<HttpRequestTimesEntity> list=new ArrayList<>();
        try{
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String url=rs.getString(1);
                int count=rs.getInt(2);
                HttpRequestTimesEntity httpRequestTimesEntity=new HttpRequestTimesEntity(url,count);
                list.add(httpRequestTimesEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return list;
    }
}
