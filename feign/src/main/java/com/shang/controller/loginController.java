package com.shang.controller;

import com.shang.feign.AccountFeign;
import com.shang.utils.Phone;
import com.zhenzi.sms.ZhenziSmsClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping("/account")
public class loginController {
    @Autowired
    private AccountFeign accountFeign;
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type) {
        int count = accountFeign.login(username,password,type);
        if(count == 1){
            return "登录成功";
        }else{
            return "登录失败";
        }
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(String phone,HttpServletRequest request) {
        boolean flag = Phone.isValidPhoneNumber(phone);
        if (flag == false){
            return "手机格式错误";
        }
        try {
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "108077", "d24bd531-17f4-4a1b-a7ef-01d301e69508");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("number", phone);
            params.put("templateId", "3611");
            String[] templateParams = new String[2];
            templateParams[0] = verifyCode;  //做成随机验证吗
            templateParams[1] = "5分钟";  //有效时间
            params.put("templateParams", templateParams);
            String result = client.send(params);
            JSONObject json = new JSONObject(result);
            int code = json.getInt("code");
            String data = json.getString("data");
            if(code==0 && data.equals("发送成功")){
                json = new JSONObject();
                json.put("verifyCode", verifyCode);
                json.put("createTime", System.currentTimeMillis());
                // 将认证码存入SESSION
                request.getSession().setAttribute("verifyCode", json);
                return "短信发送成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "短信发送失败";
    }

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public String register(HttpServletRequest request, String phone, String password, String verifyCode) {
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        if(!json.getString("verifyCode").equals(verifyCode)){
            return "验证码错误";
        }
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            return "验证码已失效";
        }
        //将用户信息存入数据库
        //这里省略
        return "注册成功";
    }
}
