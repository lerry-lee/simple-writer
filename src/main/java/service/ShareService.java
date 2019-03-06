package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.ShareDaoImpl;
import entity.ShareEntity;
import utils.ToJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareService {
    public static boolean save(String username,String sdate,String category,String content,String title) {
        ShareEntity share=new ShareEntity(username,sdate,category,content,title);
        ShareDaoImpl shareDao = new ShareDaoImpl();
        return shareDao.save(share);
    }
    public static String query(int offset,int rows) throws JsonProcessingException {
        ShareDaoImpl shareDao = new ShareDaoImpl();
        List<ShareEntity> list = shareDao.query(offset,rows);
        Map<String,Object> map=new HashMap<>();
        int pages= (int) Math.ceil(shareDao.getTotal()/5.0);
        map.put("json",list);
        map.put("pages",pages);
        return ToJson.toJson(map);
    }
    public static String queryMy(String username,int offset,int rows) throws JsonProcessingException {
        ShareDaoImpl shareDao = new ShareDaoImpl();
        List<ShareEntity> list = shareDao.queryMy(username,offset,rows);
        Map<String,Object> map=new HashMap<>();
        int pages= (int) Math.ceil(shareDao.getTotal()/5.0);
        map.put("json",list);
        map.put("pages",pages);
        return ToJson.toJson(map);
    }
}
