package com.shang.controller;

import com.shang.VO.ImgVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class userController {

    @PostMapping("/upload")
    @ResponseBody
    public ImgVO upload(@RequestParam("file")MultipartFile imgFile, HttpServletRequest request){
        String src =imgFile.getOriginalFilename();
        int a = 7;
        ImgVO imgVO= new ImgVO();
        imgVO.setCode(0);
        imgVO.setMsg("success");
        imgVO.setData(src);
        return imgVO;
    }
}
