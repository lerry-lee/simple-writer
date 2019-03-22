package com.writer1.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.writer1.entity.Reflective;
import com.writer1.mapper.ReflectiveMapper;
import com.writer1.service.ReflectiveService;
import com.writer1.utils.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReflectiveServiceImpl implements ReflectiveService {
    @Autowired
    private ReflectiveMapper reflectiveMapper;

    @Override
    public int add(String username, String title, String content, int self, int comparison, int summary, int automary, String sdate) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        map.put("title", title);
        map.put("content", content);
        map.put("self", self);
        map.put("comparison", comparison);
        map.put("summary", summary);
        map.put("automatic", automary);
        map.put("sdate", sdate);
        if (reflectiveMapper.add(map) > 0) return 1;
        return 0;
    }

    @Override
    public String queryTitle(String username, int offset, int rows) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        PageHelper.offsetPage(offset, rows);
        List<Reflective> list = reflectiveMapper.queryTitle(map);
        int total = (int) new PageInfo<>(list).getTotal();
        String json = ToJson.toJson(list);
        String rst = "{\"code\":0,\"msg\":\"\",\"count\":" + total + ",\"data\":" + json + "}";
        return rst;
    }

    @Override
    public String fuzzyQuery(String username, String title, String start_date, String end_date, int offset, int rows) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        map.put("title", title);
        map.put("start_date", start_date);
        map.put("end_date", end_date);
        PageHelper.offsetPage(offset, rows);
        List<Reflective> list = reflectiveMapper.fuzzyQuery(map);
        int total = (int) new PageInfo<>(list).getTotal();
        String json = ToJson.toJson(list);
        String rst = "{\"code\":0,\"msg\":\"\",\"count\":" + total + ",\"data\":" + json + "}";
        return rst;
    }

    @Override
    public int delete(String username, int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        map.put("id", id);
        if (reflectiveMapper.delete(map) > 0) return 1;
        return 0;
    }

    @Override
    public String queryScore(String username) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("tableName", username + "_reflective");
        List<List<Object>> list = new ArrayList<>();
        List<Object> l1 = new ArrayList<>();
        List<Object> l2 = new ArrayList<>();
        List<Object> l3 = new ArrayList<>();
        List<Object> l4 = new ArrayList<>();
        List<Object> l5 = new ArrayList<>();

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

        List<Reflective> reflectiveList = reflectiveMapper.queryScore(map);
        for (Reflective r : reflectiveList) {
            list.get(0).add(String.valueOf(r.getId()));
            list.get(1).add(r.getSelf());
            list.get(2).add(r.getComparison());
            list.get(3).add(r.getSummary());
            list.get(4).add(r.getAutomatic());

        }
        return ToJson.toJson(list);
    }
}
