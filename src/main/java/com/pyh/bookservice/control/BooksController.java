/**
 * 2019.11.9 20：00
 * author:pyh
 */
package com.pyh.bookservice.control;

import com.alibaba.druid.filter.AutoLoad;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class BooksController {
    @Autowired
    BookService bookService;

    /**
     * 查询所有图书及按类型查找图书
     * @param booktype
     * @return
     */
    @GetMapping(value = "/showAllBooks")
    public List<Book> showAllBooks(@RequestParam String booktype)
    {
        return bookService.showAllBooks(booktype);
    }

    /**
     * 按名字模糊查询图书
     * @param bookname
     * @return
     */
    @GetMapping(value = "/showBooksByName")
    public List<Book> showBooksByName(@RequestParam String bookname)
    {
        return bookService.showBooksByName(bookname);
    }

}
