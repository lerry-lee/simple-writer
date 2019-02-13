package utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class ExtractJson {

    public static JSONObject extract_json(String json) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
        String tabs = jsonObject.getString("tabs");
        JSONObject tabsObject = (JSONObject) JSONObject.parse(tabs);

        //取出feedback所需要的字段
        //取出alerts值
        String feedback = tabsObject.getString("2");
        JSONArray feedbackArray = (JSONArray) JSONObject.parse(feedback);
        JSONObject alertsObject = (JSONObject) JSONObject.parse(feedbackArray.getString(0));
        String s1 = alertsObject.getString("alerts");
        String s1_1 = s1.replace("\\", "");
        String s1_1_1 = s1_1.substring(3, s1_1.length() - 3);
        //取出customised值
        JSONObject customised1Object = (JSONObject) JSONObject.parse(feedbackArray.getString(1));
        String s2 = customised1Object.getString("customised");
        String s2_2 = s2.replace("\\", "");
        String s2_2_2 = s2_2.substring(3, s2_2.length() - 3);

        JSONObject customised2Object = (JSONObject) JSONObject.parse(feedbackArray.getString(2));
        String s3 = customised2Object.getString("customised");
        String s3_3 = s3.replace("\\", "");
        String s3_3_ = s3_3.replace("\",\"", "");
        String s3_3_3 = s3_3_.substring(3, s3_3_.length() - 3);

        //取出tips所需要的字段
        String tips = tabsObject.getString("3");
        JSONArray tipsArray = (JSONArray) JSONObject.parse(tips);
        JSONObject tipsObject = (JSONObject) JSONObject.parse(tipsArray.getString(0));
        String s4 = tipsObject.getString("faq");
        String s4_4 = s4.replace("\\", "");
        String s4_4_ = s4_4.replace("\",\"", "");
        String s4_4_4 = s4_4_.substring(3, s4_4_.length() - 3);

        JSONObject json1 = new JSONObject();
        json1.put("1", s1_1_1);
        json1.put("2", s2_2_2);
        json1.put("3", s3_3_3);
        json1.put("4", s4_4_4);

        return json1;
    }
}
