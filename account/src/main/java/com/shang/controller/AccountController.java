package com.shang.controller;

import com.shang.entity.account;
import com.shang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login/{username}/{password}/{type}")
    public int login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        int count  = 0;
        switch (type){
            case "0":
                count = accountService.login(username, password);
                break;
            case "1":
                count = accountService.login(username, password);
                break;
        }
        return count;
    }
}
