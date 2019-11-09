/**
 * 2019.11.9 15:33
 * author:pyh
 */
package com.pyh.bookservice.service;

import com.pyh.bookservice.entity.Person;
import com.pyh.bookservice.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.Oneway;
import java.util.*;

@Service
public class LoginService {
    @Resource
    LoginMapper loginMapper;

    public Map login(String pid,String ps){
        Map outputdata = new HashMap();
        int status = 500;
        List<Person> list = new ArrayList<>();
        list = loginMapper.findPersonnameIsTrue(pid);
        if(list.size() > 0){
           String personpassword = loginMapper.findPersonpasswordIsTrue(pid);
            if(personpassword.equals(ps)){
                status = 200;
                outputdata.put("personId",pid);
            }else{
                outputdata.put("msg","登录失败，密码错误！");
            }
        }else{
            outputdata.put("msg","登录失败，用户名不存在！");
        }
        outputdata.put("status",status);
        return outputdata;
    }
}
