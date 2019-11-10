/**
 * 2019.11.9 14:53
 * author:pyh
 */
package com.pyh.bookservice.control;


import com.pyh.bookservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login")
    public Map longin(@RequestParam String pid, @RequestParam String ps){
        return loginService.login(pid,ps);
    }
}
