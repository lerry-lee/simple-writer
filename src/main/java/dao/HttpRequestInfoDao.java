package dao;

import entity.HttpRequestInfoEntity;
import entity.HttpRequestTimesEntity;

import java.util.List;


public interface HttpRequestInfoDao {
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity);
    public List<HttpRequestInfoEntity> query();
    public List<HttpRequestTimesEntity> queryCount();
    public List<HttpRequestInfoEntity> fuzzyQuery(String url,String start_date,String end_date,String status);
}
