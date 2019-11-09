/**
 * 2019.11.9 20:09
 * author:pyh
 */
package com.pyh.bookservice.service;

import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.mapper.BooksMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Resource
    BooksMapper booksMapper;

    public List<Book> showAllBooks(String booktype) {
        List<Book> list = new ArrayList<>();
        list = booksMapper.showAllBooks(booktype);
        return list;
    }

    public List<Book> showBooksByName(String bookname) {
        List<Book> list = new ArrayList<>();
        list = booksMapper.showBooksByName(bookname);
        return list;
    }

}
