package com.example.Controller;

import com.example.repository.BookRepository;
import com.example.repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*主界面的控制台*/
@Controller
public class MainPageController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserReporsitory userReporsitory;

    /*点击首页时能跳转到首页*/
    @GetMapping(value = "/MainPage")
    /*public String ShowMainPage(Model model,@SessionAttribute("schoolnumber")String number,User user)*/
    public String ShowMainPage(Model model){

        /*model.addAttribute("person",userReporsitory.findUserBySchoolnumber(number));*/
        model.addAttribute("books",bookRepository.findAll());
        return "/MainPage/MainPage";
    }

    //图书查询操作
    @GetMapping(value = "/MainPage/Search")
    public String querryBook(@RequestParam(value = "bookname",required = false)String bookname,Model model){

        /*bookRepository根据findByBookname方法查找到的数据会将model中的数据替换最终 页面table只会显示查询到的结果*/
        model.addAttribute("books",bookRepository.findByBookname(bookname));
        return "/MainPage/MainPage";
    }

    //图书的借阅操作
    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id")Long id){
        bookRepository.deleteById(id);

        return "redirect:/MainPage";
    }

    //注销操作
    @GetMapping(value = "/exit")
    public String Exit(){
        return "redirect:/";
    }

}
