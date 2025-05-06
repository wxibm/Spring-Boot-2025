package com.example.demo.utils;

import com.example.demo.entity.FILE;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileUtil {
    public ReturnT<FILE> uploadFile(MultipartFile file, HttpServletRequest request) {
        FILE fILE = new FILE();
        String uploadPath = System.getProperty("user.dir") + "/upload/";
        //通常还需要返回图片的URL，为了通用性，需要动态获取协议，不要固定写死
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/upload/";
        System.out.println("图片上传，保存位置：" + uploadPath);
        //生成新的文件名称，原因：防止文件名称一样后者上传的文件会覆盖前者上传的文件（前提是文件名称必须一样并且在用一个目录下）
        //生成新的文件名称，保证文件名称唯一有两种方法：
        // 	  1.通过UUID实现文件名称唯一 （UUID会生成32位字母+数字唯一的一个字符串）
        //	  2.通过时间戳现文件名称唯一  （时间戳是毫秒级时间 时间会一直往上加，生成13位数字）注意只有java生成13位 其他则是10位比如oracle、mysql、php
        //  获取时间戳
        //long currentTimeMillis = System.currentTimeMillis();
        //System.out.println(currentTimeMillis);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String oldName = file.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        String newName = uuid + suffix;
        File newFile = new File(uploadPath + newName);
        try {
            file.transferTo(newFile);
            fILE.setFileTitle(newName);
            fILE.setFileSize(newFile.length() / 1024 + "KB");
            fILE.setFileUrl(serverPath + newName);
            return ReturnT.Success(fILE);
        } catch (IOException e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
