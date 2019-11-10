/**
 * 2019.11.9 20:10
 * author:pyh
 */

package com.pyh.bookservice.mapper;

import com.pyh.bookservice.VO.BookVO;
import com.pyh.bookservice.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BooksMapper {
    /**
     * 查找全部图书(未删除)
     * @return
     */
    List<BookVO> showAllBooks(@Param("booktype")String booktype);

    /**
     * 按名字模糊查询图书（未删除）
     * @return
     */
    List<BookVO> showBooksByName(@Param("bookname")String bookname);

    /**
     * 查找全部图书(全部)
     * @return
     */
    List<BookVO> showAllBooksByAdmin(@Param("booktype")String booktype);

    /**
     * 管理员新增图书
     * @param book
     * @return
     */
    int addBooksByAdmin(Book book);

    /**
     * 删除指定id的图书
     * @param bookid
     */
    void removeBook(@Param("bookid")String bookid);

    /**
     * 修改指定id的图书的删除状态（软删除）
     * @param bookdelete
     */
    void deleteBooksByAdmin(@Param("bookid")String bookid,@Param("bookdelete")String bookdelete);

    /**
     * 修改指定id的图书的借阅状态
     * @param bookstatus
     */
    void borrowBook(@Param("bookid")String bookid,@Param("bookstatus")String bookstatus);

    /**
     * 新增借阅数据
     * @param personbookid
     * @param bookid
     * @param personid
     * @param createdate
     * @return
     */
    int addPersonBook(@Param("personbookid")String personbookid,@Param("bookid")String bookid,@Param("personid")String personid,@Param("createdate") Date createdate);

    /**
     * 添加指定图书id和借阅人id的还书时间
     * @param bookid
     * @param personid
     * @param deaddate
     */
    void giveBackBook(@Param("bookid")String bookid,@Param("personid")String personid,@Param("deaddate")Date deaddate);

    /**
     * 查询指定id已借出的图书
     * @return
     */
    List<BookVO> showBooksById(@Param("bookid")String bookid);
}
