package dao;

import entity.UserEntity;

public interface UserDao {
    public boolean login_check(UserEntity user);
    public boolean query_with_username(String username);
    public boolean save(UserEntity user);
    public boolean update(UserEntity user,String password_new);
}
