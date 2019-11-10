package com.pyh.bookservice.control;

import com.pyh.bookservice.VO.PersonVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 查询所有人员及按人员身份查找人员
     * @param usertype
     * @return
     */
    @GetMapping(value = "/showAllPerson")
    public List<PersonVO> showAllPerson(@RequestParam String usertype)
    {
        return personService.showAllPerson(usertype);
    }

    /**
     * 按名字模糊查询人员
     * @param personname
     * @return
     */
    @GetMapping(value = "/showPersonByName")
    public List<PersonVO> showPersonByName(@RequestParam String personname)
    {
        return personService.showPersonByName(personname);
    }

    /**
     * 查询个人信息
     * @param personid
     * @return
     */
    @GetMapping(value = "/showPersonInfo")
    public Map showPersonInfo(@RequestParam String personid)
    {
        return personService.showPersonInfo(personid);
    }
}
