/**
 * 2019.11.9 20：00
 * author:pyh
 */
package com.pyh.bookservice.control;

import com.alibaba.druid.filter.AutoLoad;
import com.pyh.bookservice.VO.BookVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class BooksController {
    @Autowired
    BookService bookService;

    /**
     * 查询所有图书及按类型查找图书（未删除）
     * @param booktype
     * @return
     */
    @GetMapping(value = "/showAllBooks")
    public List<BookVO> showAllBooks(@RequestParam String booktype)
    {
        return bookService.showAllBooks(booktype);
    }

    /**
     * 按名字模糊查询图书（未删除）
     * @param bookname
     * @return
     */
    @GetMapping(value = "/showBooksByName")
    public List<BookVO> showBooksByName(@RequestParam String bookname)
    {
        return bookService.showBooksByName(bookname);
    }

    /**
     * 查询所有图书（全部）
     * @param booktype
     * @return
     */
    @GetMapping(value = "/admin/showAllBooks")
    public List<BookVO> showAllBooksByAdmin(@RequestParam String booktype)
    {
        return bookService.showAllBooksByAdmin(booktype);
    }

    /**
     * 新增图书
     * @param inputdata
     * @return
     */
    @PostMapping(value = "/admin/addBook")
    public Map addBooksByAdmin(@RequestBody Map inputdata){
        String isNew = "";
        try {
            isNew = inputdata.get("new").toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        Book newBook = new Book();
        newBook.setBookname(inputdata.get("bookname").toString());
        newBook.setBookno(inputdata.get("bookno").toString());
        newBook.setBookauthor(inputdata.get("bookauthor").toString());
        newBook.setBooktype(inputdata.get("booktype").toString());
        newBook.setBooknum(inputdata.get("booknum").toString());
        newBook.setBookpic(inputdata.get("bookpic").toString());
        if(isNew.equals("add")){
            newBook.setBookid(UUID.randomUUID().toString());
            newBook.setBookstatus("0");
            newBook.setBookdelete("0");
        }else if(isNew.equals("update")){
            newBook.setBookid(inputdata.get("bookid").toString());
            newBook.setBookstatus(inputdata.get("bookstatus").toString());
            newBook.setBookdelete(inputdata.get("bookdelete").toString());
        }
        return bookService.addBooksByAdmin(newBook,isNew);
    }

    /**
     * 修改指定id的图书的删除状态（软删除）
     * @param bookid
     * @param bookdelete
     * @return
     */
    @GetMapping(value = "/admin/deleteBook")
    public Map deleteBooksByAdmin(@RequestParam String bookid,@RequestParam String bookdelete)
    {
        return bookService.deleteBooksByAdmin(bookid,bookdelete);
    }

    /**
     * 修改指定id的图书的借书状态
     * @param personid
     * @param bookid
     * @param bookstatus
     * @return
     */
    @GetMapping(value = "/borrowBook")
    public Map borrowBook(@RequestParam String personid,@RequestParam String bookid,@RequestParam String bookstatus)
    {
        return bookService.borrowBook(personid,bookid,bookstatus);
    }


    /**
     * 查询指定我的图书   status筛选：0全部借阅过的书，1为正在借阅的书
     * @param personid
     * @param bookstatus
     * @return
     */
    @GetMapping(value = "/showMyBooks")
    public Map showMyBooks(@RequestParam String personid,@RequestParam String bookstatus)
    {
        return bookService.showMyBooks(personid,bookstatus);
    }

}
