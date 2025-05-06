package com.example.demo.entity;

import com.google.gson.Gson;

import java.math.BigDecimal;

public class Book {
    private Integer id;

    private String bookName;

    private String bookAuthor;

    private BigDecimal bookPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    //    返回该对象的字符串表示
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
