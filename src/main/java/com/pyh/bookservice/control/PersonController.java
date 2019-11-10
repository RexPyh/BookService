package com.pyh.bookservice.control;

import com.pyh.bookservice.VO.PersonVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    /**
     * 新增图书
     * @param inputdata
     * @return
     */
    @PostMapping(value = "/admin/addPerson")
    public Map addPersonByAdmin(@RequestBody Map inputdata){
        System.out.println(inputdata);
        String isNew = "";
        try {
            isNew = inputdata.get("new").toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        Person newPerson = new Person();
        newPerson.setPersonname(inputdata.get("personname").toString());
        newPerson.setPersonsex(inputdata.get("personsex").toString());
        newPerson.setPersonemail(inputdata.get("personemail").toString());
        newPerson.setPersonhome(inputdata.get("personhome").toString());
        newPerson.setPersontel(inputdata.get("persontel").toString());
        newPerson.setPersonpassword(inputdata.get("personpassword").toString());
        if(isNew.equals("add")){
            newPerson.setPersonid(UUID.randomUUID().toString());
            newPerson.setUserid("0");
            newPerson.setPersondelete("0");
        }else if(isNew.equals("update")){
            newPerson.setPersonid(inputdata.get("personid").toString());
            newPerson.setUserid(inputdata.get("userid").toString());
            newPerson.setPersondelete(inputdata.get("persondelete").toString());
        }
        return personService.addPersonByAdmin(newPerson,isNew);
    }
}
