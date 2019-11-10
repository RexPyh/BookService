package com.pyh.bookservice.service;

import com.pyh.bookservice.VO.PersonVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Resource
    private PersonMapper personMapper;

    public List<PersonVO> showAllPerson(String usertype) {
        List<PersonVO> list = new ArrayList<>();
        list = personMapper.showAllPerson(usertype);
        return list;
    }

    public List<PersonVO> showPersonByName(String personname) {
        List<PersonVO> list = new ArrayList<>();
        list = personMapper.showPersonByName(personname);
        return list;
    }

    public Map showPersonInfo(String personid) {
        Map outputdata = new HashMap();
        List<PersonVO> list = new ArrayList<>();
        list = personMapper.showPersonInfo(personid);
        outputdata.put("meta",200);
        outputdata.put("data",list);
        return outputdata;
    }

}
