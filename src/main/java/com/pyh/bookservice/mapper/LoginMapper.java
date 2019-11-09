/**
 * 2019.11.9 15:20
 * author:pyh
 */

package com.pyh.bookservice.mapper;

import com.pyh.bookservice.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {
    /**
     * 查找用户名是否存在
     * @return
     */
    List<Person> findPersonnameIsTrue(String pid);
    /**
     * 查找用户名是否有对应的密码
     * @return
     */
    String findPersonpasswordIsTrue(String pid);
}

