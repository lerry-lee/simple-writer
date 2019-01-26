package dao;

import entity.HttpRequestInfoEntity;

import java.util.List;


public interface HttpRequestInfoDao {
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity);
    public List<HttpRequestInfoEntity> query();
}
