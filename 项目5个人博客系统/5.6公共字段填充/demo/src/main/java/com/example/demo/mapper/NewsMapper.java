package com.example.demo.mapper;

import com.example.demo.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    List<News> selectNewsByUserId(@Param("userId") int userId);

    int selectUserIdByNewsId(@Param("newsId") int newsId);

    int deleteNews(@Param("newsId") int newsId);

    int insertNews(News news);

    int updateNews(News news);
}
