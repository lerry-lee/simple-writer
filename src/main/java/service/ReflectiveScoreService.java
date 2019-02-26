package service;

import bean.ReflectiveTitleBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.ReflectiveScoreDaoImpl;
import entity.ReflectiveScoreEntity;
import utils.ToJson;

import java.util.List;

public class ReflectiveScoreService {
    public static boolean save(String username, String title, String content, String self, String comparison, String summary, String automatic, String sdate) {
        ReflectiveScoreEntity scoreEntity = new ReflectiveScoreEntity(title, content, Integer.parseInt(self), Integer.parseInt(comparison), Integer.parseInt(summary), Integer.parseInt(automatic), sdate);
        ReflectiveScoreDaoImpl scoreDao = new ReflectiveScoreDaoImpl();
        return scoreDao.save(username, scoreEntity);
    }

    public static String getAll(String username, int offset, int rows) throws JsonProcessingException {
        ReflectiveScoreDaoImpl scoreDao = new ReflectiveScoreDaoImpl();
        List<ReflectiveTitleBean> list = scoreDao.query(username, offset, rows);
        int total = scoreDao.getTotal();
        String json = ToJson.toJson(list);
        String rst = "{\"code\":0,\"msg\":\"\",\"count\":" + total + ",\"data\":" + json + "}";
        return rst;
    }

    public static String fuzzyQuery(String username, int offset, int rows, String title, String start_date, String end_date) {
        ReflectiveScoreDaoImpl scoreDao = new ReflectiveScoreDaoImpl();
        List<ReflectiveTitleBean> list = scoreDao.fuzzyQuery(username, offset, rows, title, start_date, end_date);
        String list_json = null;
        try {
            list_json = ToJson.toJson(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        int total = scoreDao.getTotal();
        String rst = "{\"code\":0,\"msg\":\"\",\"count\":" + total + ",\"data\":" + list_json + "}";
        return rst;
    }

    public static String getScore(String username) {
        ReflectiveScoreDaoImpl scoreDao = new ReflectiveScoreDaoImpl();
        List<List<Object>> list = scoreDao.queryScore(username);
        String json = null;
        try {
            json = ToJson.toJson(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
