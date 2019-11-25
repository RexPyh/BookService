package com.pyh.bookservice.control;

import com.pyh.bookservice.VO.PersonVO;
import com.pyh.bookservice.entity.Book;
import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.entity.Result;
import com.pyh.bookservice.service.PersonService;
import com.pyh.bookservice.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @Resource
    private IdUtil idUtil;

    /**
     * 查询所有人员及按人员身份查找人员
     * @param usertype
     * @return
     */
    @GetMapping(value = "/showAllPerson")
    public Result showAllPerson(@RequestParam(value = "usertype", required = false) String usertype)
    {
        if(usertype == null){
            return Result.fail();
        }else {
            return Result.success(personService.showAllPerson(usertype));
        }
    }

    /**
     * 按名字模糊查询人员
     * @param personname
     * @return
     */
    @GetMapping(value = "/showPersonByName")
    public Result showPersonByName(@RequestParam(value = "personname", required = false) String personname)
    {
        if(personname == null){
            return Result.fail();
        }else {
            return Result.success(personService.showPersonByName(personname));
        }
    }

    /**
     * 查询个人信息
     * @param personid
     * @return
     */
    @GetMapping(value = "/showPersonInfo")
    public Result showPersonInfo(@RequestParam(value = "personid", required = false) String personid)
    {
        if(personid == null){
            return Result.fail();
        }else {
            return Result.success(personService.showPersonInfo(personid));
        }
    }

    /**
     * 注册新增人员或修改人员信息
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
            newPerson.setPersonid(idUtil.getRandomId());
            newPerson.setUserid("1");
            newPerson.setPersondelete("0");
        }else if(isNew.equals("update")){
            newPerson.setPersonid(inputdata.get("personid").toString());
            newPerson.setUserid(inputdata.get("userid").toString());
            newPerson.setPersondelete(inputdata.get("persondelete").toString());
        }
        return personService.addPersonByAdmin(newPerson,isNew);
    }
}
