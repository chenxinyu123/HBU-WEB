package com.how2java.springboot.service.impl;


import com.how2java.springboot.entity.*;
import com.how2java.springboot.mapper.UserMapper;
import com.how2java.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User findById(String u, String p) {
        return userMapper.findById(u,p);
    }




    @Override
    public Student student(String username) {
        return userMapper.student(username);
    }

    @Override
    public Teacher teacher(String username) {
        return userMapper.teacher(username);
    }

    @Override
    public Integer xiugai(String username,String password,String newpassword){

        return userMapper.xiugai(username,password,newpassword);

    }

    @Override
    public Integer setperson(Student student) {
        return userMapper.setperson(student);
    }

    @Override
    public List<FindProject> findProject(String kclass, int start, int laststart) {
        return userMapper.FindProject(kclass,start,laststart);
    }

    @Override
    public List<FindProject> findProject2(String kclass, int start, int laststart, String type) {
        return userMapper.FindProject2(kclass,start,laststart,type);
    }


    @Override
    public Kdetail content(String Kno) {
        return userMapper.content(Kno);
    }

    @Override
    public Voluntary serchVoluntary(String sno) {
        return userMapper.serchVoluntary(sno);
    }

    @Override
    public FindProject lookvoluntary(String kno) {
        return userMapper.lookvoluntary(kno);
    }

    @Override
    public Integer addvoluntary(Voluntary voluntary) {
        return userMapper.addvoluntary(voluntary);
    }

    @Override
    public Integer deletevoluntary(Voluntary voluntary) {
        return userMapper.deletevoluntary(voluntary);
    }

    @Override
    public Integer savamessage(String Sno, String Message) {
        return userMapper.savaMessage(Sno,Message);
    }


}
