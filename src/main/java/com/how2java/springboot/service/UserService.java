package com.how2java.springboot.service;

import com.how2java.springboot.entity.*;

import java.util.List;


public interface UserService {

    User findById(String u, String p);
    Student student(String username);
    Teacher teacher(String username);
    Integer xiugai(String username, String password, String newpassword);
    Integer setperson(Student student);
    List<FindProject> findProject(String kclass,int start,int laststart);
    List<FindProject> findProject2(String kclass,int start,int laststart,String type);
    Kdetail content(String Kno);
    Voluntary serchVoluntary(String sno);

    FindProject lookvoluntary(String kno);
    Integer addvoluntary(Voluntary voluntary);
    Integer deletevoluntary(Voluntary voluntary);
    Integer savamessage(String Sno,String Message);
}
