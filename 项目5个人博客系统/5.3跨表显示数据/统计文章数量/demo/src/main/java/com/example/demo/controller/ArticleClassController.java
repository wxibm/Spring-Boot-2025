package com.example.demo.controller;

import com.example.demo.entity.ArticleClass;
import com.example.demo.service.ArticleClassService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleClassController {
    @Autowired
    private ArticleClassService articleClassService;

    @GetMapping("/articlesClass/num")
    public ReturnT<List<ArticleClass>> selectArticleNum() {
        System.out.println("获取栏目及对应数量==========");
        return articleClassService.selectArticleNum();
    }
}
