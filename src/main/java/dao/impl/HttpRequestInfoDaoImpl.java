package dao.impl;


import bean.UrlCountBean;
import dao.BaseDao;
import dao.HttpRequestInfoDao;
import entity.HttpRequestInfoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestInfoDaoImpl implements HttpRequestInfoDao {

    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity) {
        conn = BaseDao.getconn();
        String sql = "INSERT INTO HttpRequestInfo(date,url,method,ip,param,status,timeConsuming) VALUES(?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, httpRequestInfoEntity.getDate());
            pst.setString(2, httpRequestInfoEntity.getUrl());
            pst.setString(3, httpRequestInfoEntity.getMethod());
            pst.setString(4, httpRequestInfoEntity.getIp());
            pst.setString(5, httpRequestInfoEntity.getParam());
            pst.setInt(6, httpRequestInfoEntity.getStatus());
            pst.setLong(7, httpRequestInfoEntity.getTimeConsuming());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }

    }

    @Override
    public List<HttpRequestInfoEntity> query() {
        conn = BaseDao.getconn();
        String sql = "SELECT id,date,url,param,method,ip,status,timeConsuming FROM HttpRequestInfo WHERE id<5";
        List<HttpRequestInfoEntity> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String date = rs.getString(2);
                String url = rs.getString(3);
                String param = rs.getString(4);
                String method = rs.getString(5);
                String ip = rs.getString(6);
                Integer status = rs.getInt(7);
                Long timeConsuming = rs.getLong(8);
                HttpRequestInfoEntity httpRequestInfoEntity = new HttpRequestInfoEntity(id, date, url, method, ip, param, status, timeConsuming);

                list.add(httpRequestInfoEntity);
//
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }

    @Override
    public List<UrlCountBean> queryCount() {
        conn = BaseDao.getconn();
        String sql = "SELECT url,COUNT(*) AS count from HttpRequestInfo GROUP BY url ORDER BY count DESC";
        List<UrlCountBean> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String url = rs.getString(1);
                int count = rs.getInt(2);
                UrlCountBean urlCountBean = new UrlCountBean(url, count);
                list.add(urlCountBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }

    @Override
    public List<HttpRequestInfoEntity> fuzzyQuery(String url_query, String start_date, String end_date, String str_method) {
        conn = BaseDao.getconn();
        String sql = "";
        boolean query_with_date = !start_date.equals("");
        if (!query_with_date) {
            sql = "SELECT id,date,url,param,method,ip,status,timeConsuming FROM HttpRequestInfo WHERE url LIKE ? AND method = ? ";
        } else {
            sql = "SELECT id,date,url,param,method,ip,status,timeConsuming FROM HttpRequestInfo WHERE url LIKE ? AND method = ? AND  date BETWEEN ? AND ?";
        }
        List<HttpRequestInfoEntity> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + url_query + "%");
            pst.setString(2, str_method);
            if (query_with_date) {
                pst.setString(3, start_date);
                pst.setString(4, end_date);
            }
            System.out.println(start_date+query_with_date+end_date);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String date = rs.getString(2);
                String url = rs.getString(3);
                String param = rs.getString(4);
                String method = rs.getString(5);
                String ip = rs.getString(6);
                Integer status = rs.getInt(7);
                Long timeConsuming = rs.getLong(8);
                HttpRequestInfoEntity httpRequestInfoEntity = new HttpRequestInfoEntity(id, date, url, method, ip, param, status, timeConsuming);
                list.add(httpRequestInfoEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }
}
