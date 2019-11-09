/**
 * 2019.11.9 20:10
 * author:pyh
 */

package com.pyh.bookservice.mapper;

import com.pyh.bookservice.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BooksMapper {
    /**
     * 查找全部图书
     * @return
     */
    List<Book> showAllBooks(@Param("booktype")String booktype);

    /**
     * 按名字模糊查询图书
     * @return
     */
    List<Book> showBooksByName(@Param("bookname")String bookname);
}
