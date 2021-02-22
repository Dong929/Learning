package com.shang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginConteoller {

    @RequestMapping("/index")
    public String login(){
        return  "index";
    }
}
