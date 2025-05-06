package com.example.demo.serviceImpl;

import com.example.demo.entity.News;
import com.example.demo.entity.User;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.service.NewsService;
import com.example.demo.utils.RedisClient;
import com.example.demo.utils.ReturnT;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;
    @Resource
    private RedisClient redisClient;

    public ReturnT<List<News>> selectNewsByUserId(String token) {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(redisClient.get(token), User.class);
            return ReturnT.Success(newsMapper.selectNewsByUserId(user.getId()));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

//    删除newsId的数据，需要判断newsId是否属于userId
    public ReturnT<News> deleteNews(String newsId, String token) {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(redisClient.get(token), User.class);
//            System.out.println("=========="+newsMapper.selectUserIdByNewsId(parseInt(newsId)));
//            System.out.println("************"+user.getId());
            if(newsMapper.selectUserIdByNewsId(parseInt(newsId))==user.getId()){
                newsMapper.deleteNews(parseInt(newsId));
                return ReturnT.Success();
            }
            return ReturnT.Failed("您没有权限");
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<News> insertNews(News news, String token) {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(redisClient.get(token), User.class);
            news.setUserId(user.getId());
            news.setCreateUser(user.getId());
            news.setCreateTime(LocalDateTime.now());
            news.setUpdateUser(user.getId());
            news.setUpdateTime(LocalDateTime.now());
            newsMapper.insertNews(news);
            return ReturnT.Success();
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    //修改的权限和字段，根据实际需求进行修改
    public ReturnT<News> updateNews(News news, String token) {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(redisClient.get(token), User.class);
            news.setUpdateUser(user.getId());
            news.setUpdateTime(LocalDateTime.now());
            newsMapper.updateNews(news);
            return ReturnT.Success();
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
