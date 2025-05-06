package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books/list")//获取所有书籍数据
    public ReturnT<List<Book>> selectAllBooks() {
        System.out.println("获取所有书籍数据==========");
        return bookService.selectAllBooks();
    }

    @GetMapping("/books/page")//获取分页书籍数据
    public ReturnT<List<Book>> selectAllBooks(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "10") String pageSize){
        System.out.println("获取分页书籍数据==========");
        return bookService.findAllWithPagination(pageNum, pageSize);
    }

    @GetMapping("/books/search")//获取查询书籍数据
    public ReturnT<List<Book>> selectBySearch(@RequestParam(name="condition") String condition,@RequestParam(name="content") String content){
        System.out.println("获取查询书籍数据==========");
        return bookService.selectBySearch(condition, content);
    }

    @GetMapping("/books/count")//获取书籍记录总数
    public int selectBooksCount() {
        System.out.println("获取书籍记录总数==========");
        return  bookService.selectBooksCount();
    }

    @GetMapping("/books/{bookId}")//获取地址栏参数值的书籍数据
    public ReturnT<Book> getBookByUrl(@PathVariable(value = "bookId") String id) {
        System.out.println("获取地址栏参数值的书籍数据=========="+id);
        return bookService.selectByPrimaryKey(id);
    }

    @GetMapping("/book")//获取Query参数值的书籍数据
    public ReturnT<Book> getBook(@RequestParam("bookId") String id){
        System.out.println("获取Query参数值的书籍数据=========="+id);
        return bookService.selectByPrimaryKey(id);
    }

    @PostMapping("/book")//添加书籍数据
    public ReturnT<Book> insertBook(@Validated @RequestBody Book book, BindingResult results) {
        if (results.hasErrors()) {
            String msg = "";
            //遍历错误集合
            for (ObjectError error : results.getAllErrors()) {
                msg+= error.getDefaultMessage()+"-";
            }
            return ReturnT.Failed(msg);
        }
        System.out.println("id==========" + book.getId());
        System.out.println("bookName==========" + book.getBookName());
        System.out.println("bookAuthor==========" + book.getBookAuthor());
        System.out.println("bookPrice==========" + book.getBookPrice());
        return bookService.insertBook(book);
    }

    @DeleteMapping("/books/{bookId}")//删除地址栏参数值的书籍数据
    public ReturnT<Book> deleteBookByUrl(@PathVariable(value = "bookId") String id) {
        System.out.println("删除地址栏参数值的书籍数据=========="+id);
        return bookService.deleteBook(id);
    }

    @DeleteMapping("/book")//删除Query参数值的书籍数据
    public ReturnT<Book> deleteBook(@RequestParam("bookId") String id){
        System.out.println("删除Query参数值的书籍数据==========");
        return bookService.deleteBook(id);
    }

    @PutMapping("/book")//修改书籍所有数据
    public ReturnT<Book> updateBook(@Validated @RequestBody Book book) {
        System.out.println("修改书籍所有数据==========");
        System.out.println("id==========" + book.getId());
        System.out.println("bookName==========" + book.getBookName());
        System.out.println("bookAuthor==========" + book.getBookAuthor());
        System.out.println("bookPrice==========" + book.getBookPrice());
        return bookService.updateBook(book);
    }

    @PatchMapping("/book")//修改书籍部分数据
    public ReturnT<Book> patchBook(@RequestBody Book book) {
        System.out.println("修改书籍部分数据==========");
        System.out.println("id==========" + book.getId());
        System.out.println("bookName==========" + book.getBookName());
        System.out.println("bookAuthor==========" + book.getBookAuthor());
        System.out.println("bookPrice==========" + book.getBookPrice());
        return bookService.patchBook(book);
    }
}
