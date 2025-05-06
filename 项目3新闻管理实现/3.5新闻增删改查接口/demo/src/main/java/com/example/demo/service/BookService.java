package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface BookService {
    public ReturnT<List<Book>> selectAllBooks();

    public ReturnT<List<Book>> findAllWithPagination(String pageNum, String pageSize);

    public ReturnT<List<Book>> selectBySearch(String condition, String content);

    public int selectBooksCount();

    public ReturnT<Book> selectByPrimaryKey(String id);

    public ReturnT<Book> insertBook(Book book);

    public ReturnT<Book> deleteBook(String id);

    public ReturnT<Book> updateBook(Book book);

    public ReturnT<Book> patchBook(Book book);
}
