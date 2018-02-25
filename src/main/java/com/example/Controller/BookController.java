package com.example.Controller;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*书籍的增删改查的实现*/

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //图书增加操作
    @PostMapping(value = "/addBook")
    public Book addBook(@RequestParam("bookname")String bookname,@RequestParam("author")String author,
                        @RequestParam("number")String number,@RequestParam("description")String description){
       Book book=new Book(bookname,author,number, description);
       return bookRepository.save(book);
    }

    //图书删除操作
    @GetMapping(value = "/deleteBook")
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    //图书查询操作
    @GetMapping(value = "/querryBook")
    public List<Book> querryBook(@RequestParam("bookname")String bookname){
        return bookRepository.findByBookname(bookname);
    }

    //图书修改操作
    @GetMapping(value = "/updateBook")
    public Book updateBook(@RequestParam("bookname")String bookname,@RequestParam("author")String author,
                           @RequestParam("number")String number,Long id){
        Book bookUpdate=bookRepository.findBookById(id);

        bookUpdate.setBookname(bookname);
        bookUpdate.setAuthor(author);
        bookUpdate.setNumber(number);

        return bookRepository.save(bookUpdate);
    }

}
