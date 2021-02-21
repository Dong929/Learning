package com.shang.service;

import com.shang.entity.account;
import com.shang.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public List<account> findAll(){
        return accountMapper.selectList(null);
    }

}
