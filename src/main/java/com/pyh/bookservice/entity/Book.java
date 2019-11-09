/**
 * 2019.11.9 16：25
 * author:pyh
 */
package com.pyh.bookservice.entity;

public class Book {
    private String bookid;
    private String bookname;
    private String bookno;
    private String booktype;
    private String bookstatus;

    public Book(String bookid, String bookname, String bookno, String booktype, String bookstatus) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookno = bookno;
        this.booktype = booktype;
        this.bookstatus = bookstatus;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus;
    }
}
