package com.writer1.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExtractJson {
    /*
     * 处理feature=5时返回的json
     * @tab tabs→tap→tags 保存单句的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→2→alerts 保存feedback常规声明的标签
     * @tab tabs→2→customised 保存feedback反馈声明的标签
     * */
    public static JSONObject extract_5(String json){
        JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
        String tabs = jsonObject.getString("tabs");
        JSONObject tabsObject = (JSONObject) JSONObject.parse(tabs);

        //取出analytical所需要的字段
        List<List<String>> list=new ArrayList<>();
        String tap=jsonObject.getString("tap");
        JSONArray tapObj= (JSONArray) JSONObject.parse(tap);
        for(Object strObj:tapObj){
            JSONObject strJObj= (JSONObject) strObj;
            String tags=strJObj.getString("tags");
            List<String> list1=new ArrayList<>();
            if(!tags.equals("")) {
                list1.add(strJObj.getString("str"));
                list1.add(tags);
                list.add(list1);
            }
        }
        for(List<String> list1:list){
            String[] tags=list1.get(1).split(", ");
            String s="";
            for(String tag:tags){
                if(tag.equals("contribution")) s+="S";
                else if(tag.equals("emph")) s+="E";
                else if(tag.equals("novstat")) s+="N";
                else if(tag.equals("contrast")) s+="C";
                else if(tag.equals("tempstat")) s+="B";
                else if(tag.equals("nostat")) s+="Q";
            }
            list1.add(s);
        }

        String s1_1_1="",s2_2_2="";
        String[] s1__={};
        String[] s2__={};
        //取出feedback所需要的字段
        //取出alerts值
        String feedback = tabsObject.getString("2");
        JSONArray feedbackArray = (JSONArray) JSONObject.parse(feedback);
        JSONObject alertsObject = (JSONObject) JSONObject.parse(feedbackArray.getString(0));
        String s1 = alertsObject.getString("alerts");
        if(!s1.equals("[[]]")) {
            String s1_1 = s1.replace("\\", "");
            s1_1_1 = s1_1.substring(3, s1_1.length() - 3);
            s1__=s1_1_1.split("\",\"");
        }else{
            s1__=null;
        }
        //取出customised值
        JSONObject customised1Object = (JSONObject) JSONObject.parse(feedbackArray.getString(1));
        String s2 = customised1Object.getString("customised");
        if(!s2.equals("[[]]")) {
            String s2_2 = s2.replace("\\", "");
            s2_2_2 = s2_2.substring(3, s2_2.length() - 3);
            s2__=s2_2_2.split("\",\"");
        }else{
            s2__ =null;
        }

        JSONObject json1 = new JSONObject();
        json1.put("1", s1__);
        json1.put("2", s2__);
        json1.put("3",list);

        return json1;
    }
    /*
     * 处理feature=6时返回的json
     * @tab tabs→tap→tags 保存单句的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→2→alerts 保存feedback常规声明的标签
     * @tab tabs→2→customised 保存feedback反馈声明的标签
     * */
    public static JSONObject extract_6(String json){
        JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
        String tabs = jsonObject.getString("tabs");
        JSONObject tabsObject = (JSONObject) JSONObject.parse(tabs);

        //取出analytical所需要的字段
        List<List<String>> list=new ArrayList<>();
        String tap=jsonObject.getString("tap");
        JSONArray tapObj= (JSONArray) JSONObject.parse(tap);
        for(Object strObj:tapObj){
            JSONObject strJObj= (JSONObject) strObj;
            String tags=strJObj.getString("tags");
            List<String> list1=new ArrayList<>();
            if(!tags.equals("")) {
               list1.add(strJObj.getString("str"));
               list1.add(tags);
                list.add(list1);
            }
        }
        for(List<String> list1:list){
            String[] tags=list1.get(1).split(", ");
            String s="";
            for(String tag:tags){
                if(tag.equals("contribution")) s+="S";
                else if(tag.equals("attitude")) s+="P";
                else if(tag.equals("emph")) s+="E";
                else if(tag.equals("novstat")) s+="N";
                else if(tag.equals("contrast")) s+="C";
                else if(tag.equals("tempstat")) s+="B";
                else if(tag.equals("surprise")) s+="S";
                else if(tag.equals("nostat")) s+="Q";
                else if(tag.equals("grow")) s+="T";
            }
            list1.add(s);
        }


        String s1_1_1="",s2_2_2="";
        String[] s2__={};
        //取出feedback所需要的字段
        //取出alerts值
        String feedback = tabsObject.getString("2");
        JSONArray feedbackArray = (JSONArray) JSONObject.parse(feedback);
        JSONObject alertsObject = (JSONObject) JSONObject.parse(feedbackArray.getString(0));
        String s1 = alertsObject.getString("alerts");
        if(!s1.equals("[[]]")) {
            String s1_1 = s1.replace("\\", "");
            s1_1_1 = s1_1.substring(3, s1_1.length() - 3);
        }else{
            s1_1_1 = "";
        }
        //取出customised值
        JSONObject customised1Object = (JSONObject) JSONObject.parse(feedbackArray.getString(1));
        String s2 = customised1Object.getString("customised");
        if(!s2.equals("[[]]")) {
            String s2_2 = s2.replace("\\", "");
            s2_2_2 = s2_2.substring(3, s2_2.length() - 3);
            s2__=s2_2_2.split("\",\"");
        }else{
            s2__ = null;
        }

        JSONObject json1 = new JSONObject();
        json1.put("1", s1_1_1);
        json1.put("2", s2__);
        json1.put("3",list);

        return json1;
    }
    /*
     * 处理feature=7时返回的json
     * @tab tabs→tap→tags 保存单句的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→2→alerts 保存feedback常规声明的标签
     * @tab tabs→2→customised 保存feedback反馈声明的标签
     * */
    public static JSONObject extract_7(String json) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
        String tabs = jsonObject.getString("tabs");
        JSONObject tabsObject = (JSONObject) JSONObject.parse(tabs);

        //取出analytical所需要的字段
        List<List<String>> list=new ArrayList<>();
        String tap=jsonObject.getString("tap");
        JSONArray tapObj= (JSONArray) JSONObject.parse(tap);
        for(Object strObj:tapObj){
            JSONObject strJObj= (JSONObject) strObj;
            String tags=strJObj.getString("tags");
            List<String> list1=new ArrayList<>();
            if(!tags.equals("")) {
                list1.add(strJObj.getString("str"));
                list1.add(tags);
                list.add(list1);
            }
        }
        for(List<String> list1:list){
            String[] tags=list1.get(1).split(", ");
            String s="";
            for(String tag:tags){
                if(tag.equals("contribution")) s+="S";
                else if(tag.equals("attitude")) s+="P";
                else if(tag.equals("emph")) s+="E";
                else if(tag.equals("novstat")) s+="N";
                else if(tag.equals("contrast")) s+="C";
                else if(tag.equals("tempstat")) s+="B";
                else if(tag.equals("nostat")) s+="Q";
            }
            list1.add(s);
        }


        String s1_1_1="",s2_2_2="",s3_3_3="";
        String[] s3__;
        //取出feedback所需要的字段
        //取出alerts值
        String feedback = tabsObject.getString("2");
        JSONArray feedbackArray = (JSONArray) JSONObject.parse(feedback);
        JSONObject alertsObject = (JSONObject) JSONObject.parse(feedbackArray.getString(0));
        String s1 = alertsObject.getString("alerts");
        if(!s1.equals("[[]]")) {
            String s1_1 = s1.replace("\\", "");
            s1_1_1 = s1_1.substring(3, s1_1.length() - 3);
        }else{
            s1_1_1 = "";
        }
        //取出customised值
        JSONObject customised1Object = (JSONObject) JSONObject.parse(feedbackArray.getString(1));
        String s2 = customised1Object.getString("customised");
        if(!s2.equals("[[]]")) {
            String s2_2 = s2.replace("\\", "");
            s2_2_2 = s2_2.substring(3, s2_2.length() - 3);
        }else{
            s2_2_2 = "";
        }

        JSONObject customised2Object = (JSONObject) JSONObject.parse(feedbackArray.getString(2));
        String s3 = customised2Object.getString("customised");
        if(!s3.equals("[[]]")) {
            String s3_3 = s3.replace("\\", "");
            s3_3_3 = s3_3.substring(3, s3_3.length() - 3);
            s3__=s3_3_3.split("\",\"");
        }else{
            s3__=null;
        }

        JSONObject json1 = new JSONObject();
        json1.put("1", s1_1_1);
        json1.put("2", s2_2_2);
        json1.put("3", s3__);
        json1.put("4",list);

        return json1;
    }
    /*
     * 处理feature=8时返回的json
     * @tab tabs→tap→tags 保存单句的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→tap→str 保存单句特征值的标签
     * @tab tabs→2→alerts 保存feedback常规声明的标签
     * @tab tabs→2→customised 保存feedback反馈声明的标签
     * */
    public static JSONObject extract_8(String json){
        JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
        String tabs = jsonObject.getString("tabs");
        JSONObject tabsObject = (JSONObject) JSONObject.parse(tabs);

        //取出analytical所需要的字段
        List<List<String>> list=new ArrayList<>();
        String tap=jsonObject.getString("tap");
        JSONArray tapObj= (JSONArray) JSONObject.parse(tap);
        for(Object strObj:tapObj){
            JSONObject strJObj= (JSONObject) strObj;
            String tags=strJObj.getString("tags");
            List<String> list1=new ArrayList<>();
            if(!tags.equals("")) {
                list1.add(strJObj.getString("str"));
                list1.add(tags);
                list.add(list1);
            }
        }
        for(List<String> list1:list){
            String[] tags=list1.get(1).split(", ");
            String s="";
            for(String tag:tags){
                if(tag.equals("context")) s+="1";
                else if(tag.equals("challenge")) s+="2";
                else if(tag.equals("link2me")) s+="3";
                else if(tag.equals("change")) s+="4";
            }
            list1.add(s);
        }

        String s1_1_1="",s2_2_2="";
        String[] s2__;
        //取出feedback所需要的字段
        //取出customised值
        String feedback = tabsObject.getString("2");
        JSONArray feedbackArray = (JSONArray) JSONObject.parse(feedback);
        JSONObject alertsObject = (JSONObject) JSONObject.parse(feedbackArray.getString(0));
        String s1 = alertsObject.getString("customised");
        if(!s1.equals("[[]]")) {
            String s1_1 = s1.replace("\\", "");
            String s1_1_=s1_1.replace("\",\"", "");
            s1_1_1 = s1_1_.substring(3, s1_1_.length() - 3);
        }else{
            s1_1_1 = "";
        }
        //取出customised值
        JSONObject customised1Object = (JSONObject) JSONObject.parse(feedbackArray.getString(1));
        String s2 = customised1Object.getString("customised");
        if(!s2.equals("[[]]")) {
            String s2_2 = s2.replace("\\", "");
            s2_2_2 = s2_2.substring(3, s2_2.length() - 3);
            s2__=s2_2_2.split("\",\"");
        }else{
            s2__=null;
        }

        JSONObject json1 = new JSONObject();
        json1.put("1", s1_1_1);
        json1.put("2", s2__);
        json1.put("3",list);

        return json1;
    }
}
