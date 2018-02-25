package com.example.Controller;

import com.example.entity.User;
import com.example.repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*用户增删改查的实现*/

@RestController//处理http请求，返回json格式
@RequestMapping(value = "/users")//配置URL，让该类下的所有接口URL都映射在/users下
public class UserController {
    @Autowired//注入实例
    UserReporsitory userReporsitory;

    //增加操作
    @PostMapping(value = "/save")
    public User saveUser(@RequestParam(value = "username",required = false,defaultValue = "king")String username,
                         @RequestParam(value = "password",required =false,defaultValue = "123456")String password,
                         @RequestParam(value = "realname",required = false)String realname,
                         @RequestParam(value = "schoolnumber",required = false)String schoolnumber,@RequestParam(value = "mailbox",required = false)String mailbox){
        User user=new User(username,password, realname, schoolnumber, mailbox);
        return userReporsitory.save(user);
    }

    //查询操作
    @GetMapping(value = "/findByUsername")
    public List<User> findByUsername(@RequestParam("username")String username){
     return userReporsitory.findByUsername(username);
    }

    //删除操作
    @GetMapping(value = "/deleteUser")
    public void deleteUser(Long id){
        userReporsitory.deleteById(id);
    }

    //修改操作
   @GetMapping("/updateUser")
    public User updateUser(@RequestParam(value = "username",required = false,defaultValue = "king")String username,
                           @RequestParam(value = "password",required =false,defaultValue = "123456")String password,Long id){
        User updateUser=userReporsitory.findUserById(id);
        updateUser.setUsername(username);
        updateUser.setPassword(password);

        return userReporsitory.save(updateUser);
   }

}
