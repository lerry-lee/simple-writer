package dao.impl;

import dao.BaseDao;
import dao.HttpRequestTimesDao;
import entity.HttpRequestTimesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HttpRequestTimesDaoImpl implements HttpRequestTimesDao {
    Connection conn=null;
    PreparedStatement pst=null;

    @Override
    public void updateOrInsert(String url) {

        PreparedStatement pst1=null;
        PreparedStatement pst2=null;
        conn=BaseDao.getconn();
        String sql="SELECT * FROM HttpRequestTimes WHERE Url=?";
        //标记是更新数据还是插入新的数据
        boolean flag=false;

        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,url);

            if(pst.executeQuery().next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flag){
            String sql_="UPDATE HttpRequestTimes SET times=times+1 WHERE url=?";
            try{
                pst1=conn.prepareStatement(sql_);
                pst1.setString(1,url);
                int rs=pst1.executeUpdate();
                /*if(rs>0){
                    System.out.println("Http请求次数更新,HttpRequestTimes表更新成功\n");
                }*/
                pst1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            String sql_="INSERT INTO HttpRequestTimes(url,times) VALUES(?,?)";
            try{
                pst2=conn.prepareStatement(sql_);
                pst2.setString(1,url);
                pst2.setInt(2,1);
                int rs=pst2.executeUpdate();
               /* if(rs>0){
                    System.out.println("新的Http请求，HttpRequestTimes表插入成功\n");
                }*/
                pst2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        BaseDao.addClose(pst,conn);
    }

    @Override
    public List<HttpRequestTimesEntity> query() {
        conn=BaseDao.getconn();
        String sql="SELECT * FROM HttpRequestTimes";
        List<HttpRequestTimesEntity> list=new ArrayList<>();
        try{
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String url=rs.getString(2);
                Integer times=rs.getInt(3);
                HttpRequestTimesEntity httpRequestTimesEntity =new HttpRequestTimesEntity(url,times);
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
