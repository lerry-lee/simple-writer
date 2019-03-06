package dao.impl;

import bean.CommentsBean;
import dao.BaseDao;
import dao.CommentsDao;
import entity.CommentsEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDaoImpl implements CommentsDao {
    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public boolean save(CommentsEntity comments) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "INSERT INTO comments(sid,comment,cdate,commentator) VALUES(?,?,?,?)";
        String sql_="UPDATE share SET totalComments=totalComments+1 WHERE id=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, comments.getSid());
            pst.setString(2, comments.getComment());
            pst.setString(3,comments.getCdate());
            pst.setString(4,comments.getCommentator());
            int rs = pst.executeUpdate();
            if (rs > 0)
                flag = true;
            pst=conn.prepareStatement(sql_);
            pst.setInt(1,comments.getSid());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return flag;
    }

    @Override
    public List<CommentsBean> query(int sid) {
        List<CommentsBean> list = new ArrayList<>();
        conn = BaseDao.getconn();
        String sql = "SELECT comment,cdate,commentator FROM comments WHERE sid=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,sid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CommentsBean comments = new CommentsBean(rs.getString(1),rs.getString(2),rs.getString(3));
                list.add(comments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return list;
    }

}
