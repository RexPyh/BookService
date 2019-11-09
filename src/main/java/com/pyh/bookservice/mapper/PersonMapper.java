package com.pyh.bookservice.mapper;

import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {
    /**
     * 查找全部人员
     * @return
     */
    List<Person> showAllPerson(@Param("userid")String userid);
}
