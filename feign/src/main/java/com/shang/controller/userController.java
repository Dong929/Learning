package com.shang.controller;

import com.shang.VO.ImgVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class userController {

    @PostMapping("/upload")
    @ResponseBody
    public ImgVO upload(@RequestParam("file")MultipartFile imgFile, HttpServletRequest request){
        String imgName = "";
        if(imgFile.getSize()>0) {
            //获取保存上传⽂件的file路径
            String path = "F:\\design\\Learning\\feign\\src\\main\\resources\\static\\image";
            imgName = imgFile.getOriginalFilename();
            File file = new File(path,imgName);
            try {
                imgFile.transferTo(file);
//                         path=path+img;
                //回显
//                        String path2="http://localhost:8080/images/";
//                         model.addAttribute("img",path2);
                //                model.addAttribute("name",name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ImgVO imgVO= new ImgVO();
        imgVO.setCode(0);
        imgVO.setMsg("success");
        imgVO.setData(imgName);
        return imgVO;
    }
}
