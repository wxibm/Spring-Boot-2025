package com.example.demo.service;

import com.example.demo.entity.FILE;
import com.example.demo.utils.ReturnT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public ReturnT<FILE> insertFile(MultipartFile file, HttpServletRequest request);

    public ReturnT<FILE> insertFiles(MultipartFile[] files, HttpServletRequest request);
}
