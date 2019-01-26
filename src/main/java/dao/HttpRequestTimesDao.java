package dao;

import entity.HttpRequestTimes;

import java.util.ArrayList;
import java.util.List;

public interface HttpRequestTimesDao {

    public void updateOrInsert(String url);
    public List<HttpRequestTimes> query();
}
