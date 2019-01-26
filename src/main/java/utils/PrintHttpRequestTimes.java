package utils;

import java.util.Iterator;
import java.util.Map;

public class PrintHttpRequestTimes {
    public static void printRequestTimes(Map<String,Integer> map){

        Iterator iterator= (Iterator) map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry= (Map.Entry<String, Integer>) iterator.next();
            System.out.println("访问"+entry.getKey()+"了"+entry.getValue()+"次");
        }
    }
}
