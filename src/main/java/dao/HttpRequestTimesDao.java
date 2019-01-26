package dao;

import entity.HttpRequestTimesEntity;

import java.util.List;

public interface HttpRequestTimesDao {

    public void updateOrInsert(String url);
    public List<HttpRequestTimesEntity> query();
}
