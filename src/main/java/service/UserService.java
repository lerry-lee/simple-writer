package service;

import dao.impl.UserDaoImpl;
import entity.UserEntity;

public class UserService {
    public static boolean login(UserEntity user) {
        UserDaoImpl u = new UserDaoImpl();
        return u.login_check(user);
    }
    public static boolean usernameExist(String username){
        UserDaoImpl u=new UserDaoImpl();
        return u.query_with_username(username);
    }
    public static boolean save(UserEntity user){
        UserDaoImpl u=new UserDaoImpl();
        return u.save(user);
    }
    public static boolean changePassword(UserEntity user,String password_new){
        UserDaoImpl userDao=new UserDaoImpl();
        return userDao.update(user,password_new);
    }
}
