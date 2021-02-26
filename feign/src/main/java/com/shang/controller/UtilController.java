package com.shang.controller;

import com.shang.utils.ReflectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class UtilController {
    @RequestMapping("/major")
    public List<String> getMajor(){
        return ReflectUtils.getMajor();
    }
}
