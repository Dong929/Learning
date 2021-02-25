package com.shang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/index")
    public String index(){
        return  "index";
    }

    @RequestMapping("/login")
    public String login(){
        return  "login";
    }
    @RequestMapping("/header")
    public String header(){
        return  "/common/header.html";
    }

    @RequestMapping("/header2")
    public String header2(){
        return  "/common/header.html";
    }
}
