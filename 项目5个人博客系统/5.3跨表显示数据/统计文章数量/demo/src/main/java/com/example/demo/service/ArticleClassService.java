package com.example.demo.service;

import com.example.demo.entity.ArticleClass;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface ArticleClassService {
    public ReturnT<List<ArticleClass>> selectArticleNum();
}
