package com.example.demo.entity;

public class ArticleClass {
    private Integer article_class_id;

    private String article_class_name;

//    自定义字段
    private String article_num;

    public Integer getArticle_class_id() {
        return article_class_id;
    }

    public void setArticle_class_id(Integer article_class_id) {
        this.article_class_id = article_class_id;
    }

    public String getArticle_class_name() {
        return article_class_name;
    }

    public void setArticle_class_name(String article_class_name) {
        this.article_class_name = article_class_name;
    }

    public String getArticle_num() {
        return article_num;
    }

    public void setArticle_num(String article_num) {
        this.article_num = article_num;
    }
}
