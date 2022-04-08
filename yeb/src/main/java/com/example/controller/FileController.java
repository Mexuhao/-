package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileController {

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
        log.info("上传的信息:file={}",file.getSize());
        if (!file.isEmpty()) {
            System.out.println("文件");
            System.out.println(file.isEmpty());
            String originalfilename = file.getOriginalFilename();
            file.transferTo(new File("D:\\springbootfiles\\" + originalfilename));
        }
        return "office";
    }
}
