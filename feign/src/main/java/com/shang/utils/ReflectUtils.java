package com.shang.utils;

import org.apache.commons.lang.reflect.FieldUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReflectUtils{
    /**
     * 获得学校所在专业
     * @return
     */
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

    /**
     *  时间间隔(天)
     * @param startTime
     * @param endTime
     * @return
     */
    public static int time_interval(String startTime, String endTime){
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        int i=0;
        try {
            Date star = dft.parse(startTime);//开始时间
            Date endDay=dft.parse(endTime);//结束时间
            Date nextDay=star;
            while(nextDay.before(endDay)){//当明天不在结束时间之前是终止循环
                Calendar cld = Calendar.getInstance();
                cld.setTime(star);
                cld.add(Calendar.DATE, 1);
                star = cld.getTime();
                //获得下一天日期字符串
                nextDay = star;
                i++;
            }
            System.out.println("star:"+star+"  end:"+endDay);
            System.out.println("相差天数为："+i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  i;
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
