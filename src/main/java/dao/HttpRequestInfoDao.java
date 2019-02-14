package dao;

import com.alibaba.fastjson.JSONArray;
import entity.HttpRequestInfoEntity;
import bean.UrlCountBean;

import java.util.List;


public interface HttpRequestInfoDao {
    public void insert(HttpRequestInfoEntity httpRequestInfoEntity);
    public List<HttpRequestInfoEntity> query(int offset,int rows);
    public List<UrlCountBean> queryCount();
    public List<HttpRequestInfoEntity> fuzzyQuery(int offset,int rows,String url,String start_date,String end_date,String status);

}
