package dao;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public final class BaseDao {

    public static Connection getconn(){
        Connection conn=null;
        Properties properties=new Properties();
        InputStream inputStream=BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String USERNAME=properties.getProperty("USERNAME");
        String PASSWORD=properties.getProperty("PASSWORD");
        String DRIVER=properties.getProperty("DRIVER");
        String URL=properties.getProperty("URL");
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
