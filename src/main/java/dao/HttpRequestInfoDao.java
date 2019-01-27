package dao;

import entity.HttpRequestInfoEntity;
import entity.HttpRequestTimesEntity;

import java.util.List;


public interface HttpRequestInfoDao {
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity);
    public List<HttpRequestInfoEntity> query();
    public List<HttpRequestTimesEntity> queryCount();
    public List<HttpRequestInfoEntity> urlQuery(String url);
}
