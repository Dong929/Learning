package com.shang.controller;

import com.shang.util.Phone;
import com.zhenzi.sms.ZhenziSmsClient;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class loginController {
    @RequestMapping("/sendSms")
    @ResponseBody
//    public String sendSms(HttpServletRequest request, String phone) {
     public Object sendSms(String phone) {
        Phone phone1 =new Phone();
        boolean flag = phone1.phone(phone);
        int a=7;
        if(flag == true){
            int b=7;
            return "1111111";
//            try {
//                ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "108077", "d24bd531-17f4-4a1b-a7ef-01d301e69508");
//                Map<String, Object> params = new HashMap<String, Object>();
//                params.put("number", "17875136521");
//                params.put("templateId", "3611");
//                String[] templateParams = new String[2];
//                templateParams[0] = "3421";  //做成随机验证吗
//                templateParams[1] = "5分钟";  //有效时间
//                params.put("templateParams", templateParams);
//                String result = client.send(params);
//                JSONObject json = new JSONObject(result);
//                int code = json.getInt("code");
//                String data = json.getString("data");
//                int a= 1;
//                return  result;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }else{
            return "222222";
        }
//        try {
//            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "108077", "d24bd531-17f4-4a1b-a7ef-01d301e69508");
//            Map<String, Object> params = new HashMap<String, Object>();
//            params.put("number", "17875136521");
//            params.put("templateId", "3611");
//            String[] templateParams = new String[2];
//            templateParams[0] = "3421";  //做成随机验证吗
//            templateParams[1] = "5分钟";  //有效时间
//            params.put("templateParams", templateParams);
//            String result = client.send(params);
//            System.out.println("result:"+result);
//            return  result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "11111";
    }
}
