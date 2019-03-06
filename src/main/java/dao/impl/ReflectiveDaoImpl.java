package dao.impl;

import bean.ReflectiveTitleBean;
import dao.BaseDao;
import dao.ReflectiveDao;
import entity.ReflectiveEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReflectiveDaoImpl implements ReflectiveDao {
    Connection conn = null;
    PreparedStatement pst = null;
    @Getter
    @Setter
    private int total;

    @Override
    public boolean save(String username, ReflectiveEntity scoreEntity) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "INSERT INTO " + username + "_reflective" +
                "(title,content,self,comparison,summary,automatic,sdate) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, scoreEntity.getTitle());
            pst.setString(2, scoreEntity.getContent());
            pst.setInt(3, scoreEntity.getSelf());
            pst.setInt(4, scoreEntity.getComparison());
            pst.setInt(5, scoreEntity.getSummary());
            pst.setInt(6, scoreEntity.getAutomatic());
            pst.setString(7, scoreEntity.getSdate());
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
    public List<ReflectiveTitleBean> query(String username, int offset, int rows) {
        List<ReflectiveTitleBean> list = new ArrayList<>();
        conn = BaseDao.getconn();
        String sql = "SELECT SQL_CALC_FOUND_ROWS id,title,sdate FROM " + username + "_reflective" +
                " LIMIT ?,?";
        String sql_total = "SELECT FOUND_ROWS()";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, offset);
            pst.setInt(2, rows);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ReflectiveTitleBean scoreEntity = new ReflectiveTitleBean(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(scoreEntity);
            }
            pst = conn.prepareStatement(sql_total);
            ResultSet rs_total = pst.executeQuery();
            while (rs_total.next())
                setTotal(rs_total.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }

    public List<ReflectiveTitleBean> fuzzyQuery(String username,int offset, int rows, String title_query, String start_date, String end_date) {
        conn = BaseDao.getconn();
        String sql = "";
        String sql_ = "SELECT FOUND_ROWS()";
        boolean query_with_date = !start_date.equals("");
        boolean query_with_title=!title_query.equals("");
        if (query_with_title) {
            if(query_with_date)
                sql = "SELECT SQL_CALC_FOUND_ROWS id,title,sdate FROM" +username + "_reflective" +
                        "  WHERE title LIKE ? AND  sdate BETWEEN ? AND ? LIMIT ?,?";
            else
                sql="SELECT SQL_CALC_FOUND_ROWS id,title,sdate FROM " +username + "_reflective" +
                        " WHERE title LIKE ? LIMIT ?,?";
        } else {
            if(query_with_date)
                sql = "SELECT SQL_CALC_FOUND_ROWS id,title,sdate FROM " +username + "_reflective" +
                        " WHERE sdate BETWEEN ? AND ? LIMIT ?,?";
            else
                sql="SELECT SQL_CALC_FOUND_ROWS id,title,sdate FROM " +username + "_reflective" +
                        "  LIMIT ?,?";
        }
        List<ReflectiveTitleBean> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            if (query_with_title) {
                if(query_with_date) {
                    pst.setString(1, "%" + title_query + "%");
                    pst.setString(2, start_date);
                    pst.setString(3, end_date);
                    pst.setInt(4, offset);
                    pst.setInt(5, rows);
                }else {
                    pst.setString(1, "%" + title_query + "%");
                    pst.setInt(2, offset);
                    pst.setInt(3, rows);
                }
            } else {
                if(query_with_date) {
                    pst.setString(1, start_date);
                    pst.setString(2, end_date);
                    pst.setInt(3, offset);
                    pst.setInt(4, rows);
                }else {
                    pst.setInt(1, offset);
                    pst.setInt(2, rows);
                }
            }
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String sdate = rs.getString(3);

                ReflectiveTitleBean reflectiveTitleBean = new ReflectiveTitleBean(id, title, sdate);
                list.add(reflectiveTitleBean);
            }
            pst = conn.prepareStatement(sql_);
            ResultSet rs_ = pst.executeQuery();
            while (rs_.next()) {
                setTotal(rs_.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }
    public List<List<Object>> queryScore(String username){
        conn=BaseDao.getconn();
        List<List<Object>> list=new ArrayList<>();
        List<Object> l1=new ArrayList<>();
        List<Object> l2=new ArrayList<>();
        List<Object> l3=new ArrayList<>();
        List<Object> l4=new ArrayList<>();
        List<Object> l5=new ArrayList<>();
        l1.add("sdate");
        l2.add("self");
        l3.add("comparison");
        l4.add("summary");
        l5.add("automatic");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);


        String sql="SELECT sdate,self,comparison,summary,automatic FROM "+username+"_reflective";
        try{
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                list.get(0).add(rs.getString(1));
                list.get(1).add(rs.getInt(2));
                list.get(2).add(rs.getInt(3));
                list.get(3).add(rs.getInt(4));
                list.get(4).add(rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return list;
    }
}
