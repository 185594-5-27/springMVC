package com.springboot.example.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by linzf on 2017/4/2.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @RequestMapping("/toUpload.do")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping("/upload.do")
    @ResponseBody
    public String upload(MultipartFile multipartFile){
        try {
            FileUtils.writeByteArrayToFile(new File("e:/upload/"+multipartFile.getOriginalFilename()),multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
