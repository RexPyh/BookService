package com.pyh.bookservice.control;

import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Person> showAllPerson(@RequestParam String usertype)
    {
        return personService.showAllPerson(usertype);
    }
}
