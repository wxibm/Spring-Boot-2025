package com.example.demo.service;

import com.example.demo.entity.News;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface NewsService {
    public ReturnT<List<News>> selectNewsByUserId(String userId);

    public ReturnT<News> deleteNews(String newsId, String token);
}
