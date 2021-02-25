package com.shang.utils;

import org.apache.commons.lang.reflect.FieldUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtils{
    public static List<String> getMajor(){
        String url = "https://www.zhku.edu.cn/";
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url),10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list =new ArrayList<String>();
        String str = null;
        Elements elements = document.getElementsByClass("c56020_select");
        for (Element element1 :elements){
            Elements element2s = element1.getElementsByTag("option");
            for (Element element2 :element2s){
                str = element2.text();
                if(!str.equals("教学机构")){
                    list.add(str);
                }
            }
        }
        return  list;
    }

    public static Object getFieldValue(Object obj, String fieldName){
        if(obj == null){
            return null ;
        }
        Field targetField = getTargetField(obj.getClass(), fieldName);

        try {
            return FieldUtils.readField(targetField, obj, true ) ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static Field getTargetField(Class<?> targetClass, String fieldName) {
        Field field = null;

        try {
            if (targetClass == null) {
                return field;
            }

            if (Object.class.equals(targetClass)) {
                return field;
            }

            field = FieldUtils.getDeclaredField(targetClass, fieldName, true);
            if (field == null) {
                field = getTargetField(targetClass.getSuperclass(), fieldName);
            }
        } catch (Exception e) {
        }

        return field;
    }
}
