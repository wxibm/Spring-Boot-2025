package com.example.demo.serviceImpl;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.lang.Integer.parseInt;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    public ReturnT<List<Book>> selectAllBooks() {
        try {
            return ReturnT.Success(bookMapper.selectAllBooks());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<List<Book>> findAllWithPagination(String pageNum, String pageSize) {
        try {
            int offset = (parseInt(pageNum) - 1) * parseInt(pageSize);
            return ReturnT.Success(bookMapper.selectBooksByLimit(offset, parseInt(pageSize)));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<List<Book>> selectBySearch(String condition, String content) {
        try {
            return ReturnT.Success(bookMapper.selectBySearch(condition, content));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public int selectBooksCount() {
        return bookMapper.selectBooksCount();
    }

    public ReturnT<Book> selectByPrimaryKey(String id) {
        try {
            Book book = bookMapper.selectByPrimaryKey(parseInt(id));
            if (book == null)
                return ReturnT.Success("不存在此书籍");
            System.out.println(book);
            return ReturnT.Success(book);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<Book> insertBook(Book book) {
        try {
            bookMapper.insertBook(book);
            return ReturnT.Success(book);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<Book> deleteBook(String id) {
        try {
            bookMapper.deleteBook(parseInt(id));
            return ReturnT.Success();
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<Book> updateBook(Book book) {
        try {
            bookMapper.updateBook(book);
            return ReturnT.Success(book);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<Book> patchBook(Book book) {
        try {
            bookMapper.patchBook(book);
            return ReturnT.Success(book);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
