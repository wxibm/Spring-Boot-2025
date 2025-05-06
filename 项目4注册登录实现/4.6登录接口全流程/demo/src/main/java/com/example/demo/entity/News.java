package com.example.demo.entity;

import com.google.gson.Gson;

public class News {
    private Integer newsId;
    private String newsTitle;
    private String newsContent;
    private Integer userId;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //    返回该对象的字符串表示
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
