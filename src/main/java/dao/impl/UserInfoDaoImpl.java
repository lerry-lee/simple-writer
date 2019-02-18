package dao.impl;

import dao.BaseDao;
import dao.UserInfoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfoDaoImpl implements UserInfoDao {
    Connection conn = null;
    PreparedStatement pst = null;

    @Override
    public boolean login_check(String username, String password) {
        conn= BaseDao.getconn();
        String sql="SELECT id FROM UserInfo WHERE username = ? and PASSWORD = ?";
        boolean flag=false;
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
                flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.addClose(pst,conn);
        }
        return flag;
    }
}
