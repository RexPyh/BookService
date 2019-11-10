/**
 * 2019.11.9 20:09
 * author:pyh
 */
package com.pyh.bookservice.service;

import com.pyh.bookservice.VO.BookVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.mapper.BooksMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BookService {
    @Resource
    BooksMapper booksMapper;

    public List<BookVO> showAllBooks(String booktype) {
        List<BookVO> list = new ArrayList<>();
        list = booksMapper.showAllBooks(booktype);
        return list;
    }

    public List<BookVO> showBooksByName(String bookname) {
        List<BookVO> list = new ArrayList<>();
        list = booksMapper.showBooksByName(bookname);
        return list;
    }

    public List<BookVO> showAllBooksByAdmin(String booktype) {
        List<BookVO> list = new ArrayList<>();
        list = booksMapper.showAllBooksByAdmin(booktype);
        return list;
    }

    public Map addBooksByAdmin(Book newBook,String isNew){
        Map outputdata = new HashMap();
        int meta = 0;
        String msg = "";
        int addNum = 0;
        if(isNew.equals("add")){
            addNum = booksMapper.addBooksByAdmin(newBook);
            meta = 200;
            msg = "您已成功新增"+ addNum + "本图书";
            outputdata.put("data",newBook);
        }else if(isNew.equals("update")){
            meta = 200;
            booksMapper.removeBook(newBook.getBookid());
            addNum = booksMapper.addBooksByAdmin(newBook);
            msg = "您已成功修改图书";
            outputdata.put("data",newBook);
        }else{
            meta = 500;
            msg = "操作失败！";
        }
        outputdata.put("msg",msg);
        outputdata.put("meta",meta);
        return outputdata;
    }

    public Map deleteBooksByAdmin(String bookid,String bookdelete) {
        Map outputdata = new HashMap();
        booksMapper.deleteBooksByAdmin(bookid,bookdelete);
        outputdata.put("meta",200);
        outputdata.put("msg","您已软删一本图书！");
        return outputdata;
    }

    public Map borrowBook(String personid,String bookid,String bookstatus) {
        Map outputdata = new HashMap();
        int meta = 0;
        String msg = "";
        if(bookstatus.equals("1")){
            List<BookVO> list = booksMapper.showBooksById(bookid);
            if(list.size() > 0){
                meta = 500;
                msg = "借书失败！您所借的书已借出！";
            }else{
                booksMapper.borrowBook(bookid,bookstatus);
                String personbookid = UUID.randomUUID().toString();
                Date createdate = new Date();
                booksMapper.addPersonBook(personbookid,bookid,personid,createdate);
                meta = 200;
                msg = "您已借阅成功！";
            }
        }else if(bookstatus.equals("0")){
            booksMapper.borrowBook(bookid,bookstatus);
            Date deaddate = new Date();
            booksMapper.giveBackBook(bookid,personid,deaddate);
            meta = 200;
            msg = "您已还书成功！";
        }
        outputdata.put("meta",meta);
        outputdata.put("msg",msg);
        return outputdata;
    }

}
