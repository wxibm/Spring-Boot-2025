package com.example.demo.serviceImpl;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.service.NewsService;
import com.example.demo.utils.RedisClient;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
            int userId = parseInt(redisClient.get(token));
            return ReturnT.Success(newsMapper.selectNewsByUserId(userId));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

//    删除newsId的数据，需要判断newsId是否属于userId
    public ReturnT<News> deleteNews(String newsId, String token) {
        try {
            int userId = parseInt(redisClient.get(token));
            if(newsMapper.selectUserIdByNewsId(parseInt(newsId))==userId){
                newsMapper.deleteNews(parseInt(newsId));
                return ReturnT.Success();
            }
            return ReturnT.Failed("您没有权限");
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
