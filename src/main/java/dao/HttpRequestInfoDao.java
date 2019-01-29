package dao;

import com.alibaba.fastjson.JSONArray;
import entity.HttpRequestInfoEntity;
import bean.UrlCountBean;

import java.util.List;


public interface HttpRequestInfoDao {
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity);
    public List<HttpRequestInfoEntity> query();
    public List<UrlCountBean> queryCount();
    public List<HttpRequestInfoEntity> fuzzyQuery(String url,String start_date,String end_date,String status);

}
