package service;

import dao.impl.UserInfoDaoImpl;

public class LoginService {
    public static boolean login(String username, String password) {

        UserInfoDaoImpl u = new UserInfoDaoImpl();

        return u.login_check(username, password);
    }
}
