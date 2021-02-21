package com.shang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shang.mapper")
public class accountApplication {
    public static void main(String[] args) {
        SpringApplication.run(accountApplication.class,args);
    }
}
