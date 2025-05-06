package com.example.demo.serviceImpl;

import com.example.demo.entity.ArticleClass;
import com.example.demo.mapper.ArticleClassMapper;
import com.example.demo.service.ArticleClassService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleClassServiceImpl implements ArticleClassService {
    @Resource
    private ArticleClassMapper articleClassMapper;

    public ReturnT<List<ArticleClass>> selectArticleNum() {
        try {
            return ReturnT.Success(articleClassMapper.selectArticleNum());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
