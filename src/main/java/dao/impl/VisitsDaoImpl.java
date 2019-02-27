package dao.impl;

import dao.BaseDao;
import dao.VisitsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitsDaoImpl implements VisitsDao {
    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public boolean insertUpdate(String usersign) {
        boolean flag = false;
        conn = BaseDao.getconn();
        String sql = "INSERT IGNORE INTO Visits (usersign) VALUES (?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, usersign);
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
    public int count() {
        int visits = 0;
        conn = BaseDao.getconn();
        String sql = "SELECT COUNT(id) FROM Visits";
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                visits = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.addClose(pst, conn);
        }
        return visits;
    }
}
