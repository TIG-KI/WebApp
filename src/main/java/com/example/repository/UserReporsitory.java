package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReporsitory extends JpaRepository<User,Long> {

     /*内建查询机制
     根据用户名批量查询用户数据*/
     List<User> findByUsername(String username);

     User findUserById(Long id);
    List<User>  findByPasswordAndSchoolnumber(String password,String schoolnumber);
}
