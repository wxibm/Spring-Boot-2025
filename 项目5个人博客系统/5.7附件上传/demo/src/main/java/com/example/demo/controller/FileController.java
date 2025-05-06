package com.example.demo.controller;

import com.example.demo.entity.FILE;
import com.example.demo.service.FileService;
import com.example.demo.utils.ReturnT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
//    测试端口写file
    public ReturnT<FILE> uploadFile(MultipartFile file, HttpServletRequest request) {
        return fileService.insertFile(file, request);
    }

    @PostMapping("/uploads")
//    测试端口写files
    public ReturnT<FILE> uploadFiles(MultipartFile[] files, HttpServletRequest request) {
        return fileService.insertFiles(files, request);
    }
}
