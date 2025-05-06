package com.example.demo.serviceImpl;

import com.example.demo.entity.FILE;
import com.example.demo.mapper.FileMapper;
import com.example.demo.service.FileService;
import com.example.demo.utils.FileUtil;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    private FileMapper fileMapper;

    //    @Autowired+@Component确保可以读取yml的值
    @Autowired
    private FileUtil fileUtil;

    //上传一张图片
    public ReturnT<FILE> insertFile(MultipartFile file, HttpServletRequest request) {
        try {
//            fileUtil.uploadFile(file, request)写第二次就是null，必须触发提交事件才不为空
            ReturnT<FILE> fILE=fileUtil.uploadFile(file, request);
            if (fILE.getCode()==200) {
//                如果失败，无需事务回滚。事务回滚针对数据库，文件上传无法回滚
                fileMapper.insertFile(fILE.getData());
                return ReturnT.Success(fILE.getData());
            } else
                return ReturnT.Failed("上传失败");
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    //上传多张图片，需要事务回滚
    @Transactional(rollbackFor = SQLException.class)
    public ReturnT<FILE> insertFiles(MultipartFile[] files, HttpServletRequest request) {
        boolean bool = false;
        for (MultipartFile file : files) {
            try {
                file.getSize();
                ReturnT<FILE> fILE = fileUtil.uploadFile(file, request);
                if (fILE.getCode() == 200) {
                    fileMapper.insertFile(fILE.getData());
                    bool = true;
                } else
                    bool = false;
            } catch (Exception e) {
                //手工回滚异常
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                bool = false;
            }
        }
        if (bool)
            return ReturnT.Success();
        else
            return ReturnT.Failed();
    }
}
