package com.example.Controller;

import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/*登陆界面控制台*/
@Controller
public class homeController {
    //实体注入
    @Autowired
    UserReporsitory userReporsitory;
    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }

    //查询操作（通过名字和密码查询）
    @GetMapping(value = "/findByUsernameAndPassword")
    public String findByUsernameAndPassword(@RequestParam("password")String password,@RequestParam("schoolnumber")String schoolnumber, Model model){

        /*通过前端进行传值
        * 建立一个List<User> 对象 用findByPasswordAndUsername(password,username);方法进行关系查找
        * 如果对象为空即 Fuser.isEmpty()==true 则页面不跳转
        * 如果不为空 即数据库中存在相应的值
        * 那么页面将进行跳转*/
        List<User> Fuser=userReporsitory.findByPasswordAndSchoolnumber(password,schoolnumber);
        if (Fuser.isEmpty()){
            return "index";
        }else {
            /*model.addAttribute("books",bookRepository.findAll());
            * 这里用到 redirect 定向跳转；redirect 后跟MainPageController 中的一个映射/MainPage ;*/
            return "redirect:/MainPage";
        }
    }

}
