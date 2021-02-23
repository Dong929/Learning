package com.shang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shang.entity.account;
import com.shang.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int login(String username,String password){
        QueryWrapper wrapper = new QueryWrapper();
        Map<String,Object> map = new HashMap<>();
        map.put("account",username);
        map.put("password",password);
        wrapper.allEq(map);
        int count = accountMapper.selectCount(wrapper);
        return count;
    }

}
