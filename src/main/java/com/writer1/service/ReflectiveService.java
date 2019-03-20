package com.writer1.service;

import com.writer1.dao.ReflectiveDaoImpl;
import com.writer1.entity.Reflective;
import com.writer1.utils.ToJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectiveService {
    Reflective reflective;
    ReflectiveDaoImpl reflectiveDao;

    public ReflectiveService() {
        reflectiveDao = new ReflectiveDaoImpl();
    }

    public int save(String username, String title, String content, int self, int comparison, int summary, int automary, String sdate) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        map.put("title", title);
        map.put("content", content);
        map.put("self", self);
        map.put("comparison", comparison);
        map.put("summary", summary);
        map.put("automatic", automary);
        map.put("sdate", sdate);
        if (reflectiveDao.save(map)) return 1;
        return 0;
    }

    public String queryTitle(String username, int offset, int rows) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        String json = ToJson.toJson(reflectiveDao.queryTitle(map, offset, rows));
        int total = reflectiveDao.getTotal();
        String rst = "{\"code\":0,\"msg\":\"\",\"count\":" + total + ",\"data\":" + json + "}";
        return rst;
    }

    public String fuzzyQuery(String username, String title, String start_date, String end_date, int offset, int rows) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        map.put("title", title);
        map.put("start_date", start_date);
        map.put("end_date", end_date);
        String json = ToJson.toJson(reflectiveDao.fuzzyQuery(map, offset, rows));
        int total = reflectiveDao.getTotal();
        String rst = "{\"code\":0,\"msg\":\"\",\"count\":" + total + ",\"data\":" + json + "}";
        return rst;
    }

    public int delete(String username, int id) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        map.put("id", id);
        if (reflectiveDao.delete(map)) return 1;
        return 0;
    }

    public String queryScore(String username) throws IOException {
        Map<String,String> map=new HashMap<>();
        map.put("tableName",username+"_reflective");
        List<List<Object>> list=new ArrayList<>();
        List<Object> l1=new ArrayList<>();
        List<Object> l2=new ArrayList<>();
        List<Object> l3=new ArrayList<>();
        List<Object> l4=new ArrayList<>();
        List<Object> l5=new ArrayList<>();

        l1.add("id");
        l2.add("self");
        l3.add("comparison");
        l4.add("summary");
        l5.add("automatic");

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);

        List<Reflective> reflectiveList=reflectiveDao.queryScore(map);
        for(Reflective r:reflectiveList){
            list.get(0).add(String.valueOf(r.getId()));
            list.get(1).add(r.getSelf());
            list.get(2).add(r.getComparison());
            list.get(3).add(r.getSummary());
            list.get(4).add(r.getAutomatic());

        }
        return ToJson.toJson(list);
    }
}
