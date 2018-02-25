package com.example.repository;

import com.example.entity.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByBookname(String bookname);
    Book findBookById(Long id);

}
