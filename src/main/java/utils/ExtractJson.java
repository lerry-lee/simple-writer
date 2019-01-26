package utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ExtractJson {
    public static List<String> extract(String json){
        JSONObject jsonObject= (JSONObject) JSONObject.parse(json);
        String tabs=jsonObject.getString("tabs");
        JSONObject tabsObject= (JSONObject) JSONObject.parse(tabs);

        //取出feedback所需要的字段
        //取出alerts值
        String feedback=tabsObject.getString("2");
        JSONArray feedbackArray= (JSONArray) JSONObject.parse(feedback);
        JSONObject alertsObject= (JSONObject) JSONObject.parse(feedbackArray.getString(0));
        String s1=alertsObject.getString("alerts");
        String s1_1=s1.replace("\\","");
        String s1_1_1=s1_1.substring(3,s1_1.length()-3);
        //取出customised值
        JSONObject customised1Object= (JSONObject) JSONObject.parse(feedbackArray.getString(1));
        String s2=customised1Object.getString("customised");
        String s2_2=s2.replace("\\","");
        String s2_2_2=s2_2.substring(3,s2_2.length()-3);

        JSONObject customised2Object= (JSONObject) JSONObject.parse(feedbackArray.getString(2));
        String s3=customised2Object.getString("customised");
        String s3_3=s3.replace("\\","");
        String s3_3_=s3_3.replace("\",\"","");
        String s3_3_3=s3_3_.substring(3,s3_3_.length()-3);

        //取出tips所需要的字段
        String tips=tabsObject.getString("3");
        JSONArray tipsArray= (JSONArray) JSONObject.parse(tips);
        JSONObject tipsObject= (JSONObject) JSONObject.parse(tipsArray.getString(0));
        String s4=tipsObject.getString("faq");
        String s4_4=s4.replace("\\","");
        String s4_4_=s4_4.replace("\",\"","");
        String s4_4_4=s4_4_.substring(3,s4_4_.length()-3);

        List<String> list=new ArrayList<>();
        list.add(s1_1_1);
        list.add(s2_2_2);
        list.add(s3_3_3);
        list.add(s4_4_4);

        return list;
    }
}
