package dao;

import bean.ReflectiveTitleBean;
import entity.ReflectiveEntity;

import java.util.List;

public interface ReflectiveDao {
    public boolean save(String username, ReflectiveEntity scoreEntity);
    public List<ReflectiveTitleBean> query(String username, int offset, int rows);
    public boolean delete(String username,int id);
}
