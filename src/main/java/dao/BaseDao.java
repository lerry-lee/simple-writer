package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class BaseDao {

    public static Connection getconn(){
        Connection conn=null;

        String USERNAME="root";
        String PASSWORD="root";
        String URL="jdbc:mysql://localhost:3306/writer1?useSSL=false";
        String DRIVER="com.mysql.jdbc.Driver";

        try{
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void addClose(PreparedStatement pst,Connection conn){
        try{
            if(pst!=null){
                pst.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }
    }

}
