package dao;

import bean.ReflectiveTitleBean;
import entity.ReflectiveScoreEntity;

import java.util.List;

public interface ReflectiveScoreDao {
    public boolean save(String username,ReflectiveScoreEntity scoreEntity);
    public List<ReflectiveTitleBean> query(String username, int offset, int rows);
}
