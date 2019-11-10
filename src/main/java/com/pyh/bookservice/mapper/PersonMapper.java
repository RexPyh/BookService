package com.pyh.bookservice.mapper;

import com.pyh.bookservice.VO.PersonVO;
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
    List<PersonVO> showAllPerson(@Param("userid")String userid);

    /**
     * 查找全部人员
     * @return
     */
    List<PersonVO> showPersonByName(@Param("personname")String personname);

    /**
     * 查询个人信息
     * @return
     */
    List<PersonVO> showPersonInfo(@Param("personid")String personid);

    /**
     * 注册新增人员
     * @param person
     * @return
     */
    int addPersonByAdmin(Person person);

    /**
     * 删除指定id的人员
     * @param personid
     */
    void removePerson(@Param("personid")String personid);

}
