package com.example.entity;

import javax.persistence.*;

@Entity
public class User {
  //id自增
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //用户昵称
    private String username;
    //密码
    private String password;
    //真实名
    private String realname;

    //学号
    private String schoolnumber;
    //邮箱
    private String mailbox;

    /*实体类中有带参的构造函数导致默认的无参构造函数失效，
     进行面向对象查询时需要用到无参构造函数，所以再此必须添加一个无参构造函数否则会报错*/
    public User(){}
    public User(String username, String password, String realname, String schoolnumber, String mailbox) {

        this.username = username;
        this.password = password;
        this.realname = realname;
        this.schoolnumber = schoolnumber;
        this.mailbox = mailbox;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getSchoolnumber() {
        return schoolnumber;
    }

    public void setSchoolnumber(String schoolnumber) {
        this.schoolnumber = schoolnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
