package com.example.Controller;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*还书界面控制台*/

@Controller
public class ManagementController {

    @Autowired //实体注入
    BookRepository bookRepository;

    @GetMapping(value = "/Management/")
    public String ShowManamgementPage(){
        return "/Management/management";
    }

    //图书增加操作
    @PostMapping(value = "/Management/AddBook")
    public String addBook(@RequestParam(value = "bookname",required = false)String bookname, @RequestParam(value = "author",required = false)String author,
                        @RequestParam(value = "number",required = false)String number,@RequestParam(value = "description",required = false)String description){
       Book book=new Book(bookname,author,number, description);
       bookRepository.save(book);

       return "redirect:/MainPage";
    }
}
