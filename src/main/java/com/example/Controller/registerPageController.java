package com.example.Controller;

import com.example.entity.User;
import com.example.repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*注册界面控制台*/

@Controller
@RequestMapping(value = "/Register")
public class registerPageController {

    @Autowired
    UserReporsitory userReporsitory;

    @GetMapping(value = "/registerPage")
    public String showRegisterPage(){
        return "Register/registerPage";
    }


    //增加操作
    @PostMapping(value = "/save")
    public String saveUser(@RequestParam(value = "username",required = false,defaultValue = "king")String username,
                         @RequestParam(value = "password",required =false,defaultValue = "123456")String password,
                         @RequestParam(value = "realname",required = false)String realname,
                         @RequestParam(value = "schoolnumber",required = false)String schoolnumber,@RequestParam(value = "mailbox",required = false)String mailbox){
        User user=new User(username,password, realname, schoolnumber, mailbox);
        userReporsitory.save(user);
        return "index";
    }
}
