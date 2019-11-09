package com.pyh.bookservice.service;

import com.pyh.bookservice.VO.PersonVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Resource
    private PersonMapper personMapper;

    public List<Person> showAllPerson(String usertype) {
        List<Person> list = new ArrayList<>();
        list = personMapper.showAllPerson(usertype);
        return list;
    }

    public List<PersonVO> showPersonByName(String personname) {
        List<PersonVO> list = new ArrayList<>();
        list = personMapper.showPersonByName(personname);
        return list;
    }

}
