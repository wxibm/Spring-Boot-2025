package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/news/userId")
    public ReturnT<List<News>> selectNewsByUserId(@RequestHeader("token") String token){
        System.out.println("根据userId获取新闻列表==========");
        return newsService.selectNewsByUserId(token);
    }

    @DeleteMapping("/news")
    public ReturnT<News> deleteNews(@RequestParam("newsId") String newsId,@RequestHeader("token") String token){
        System.out.println("根据newsId删除新闻数据==========");
        return newsService.deleteNews(newsId,token);
    }
}
