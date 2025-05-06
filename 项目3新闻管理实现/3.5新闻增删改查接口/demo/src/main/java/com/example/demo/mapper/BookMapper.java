package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    List<Book> selectAllBooks();

    List<Book> selectBooksByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Book> selectBySearch(@Param("condition") String condition, @Param("content") String content);

    int selectBooksCount();

    Book selectByPrimaryKey(@Param("id") Integer id);

    int insertBook(Book book);

    int deleteBook(@Param("id") int id);

    int updateBook(Book book);

    int patchBook(Book book);
}
