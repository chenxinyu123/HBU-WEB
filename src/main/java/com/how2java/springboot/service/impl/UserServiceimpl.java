package com.how2java.springboot.service.impl;


import com.how2java.springboot.entity.*;
import com.how2java.springboot.mapper.UserMapper;
import com.how2java.springboot.service.UserService;
import com.how2java.springboot.webentity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public String findById(String u, String p) {
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
    public List<Course> findProject(String kclass, int start, int laststart) {
        return userMapper.FindProject(kclass,start,laststart);
    }

    @Override
    public List<Course> findProject2(String kclass, int start, int laststart, String type) {
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
    public Course lookvoluntary(String kno) {
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

    @Override
    public List<Voluntary> getVoluntary() {
        return userMapper.getVoluntary();
    }

    @Override
    public String getState(String kno) {
        return userMapper.getState(kno);
    }

    @Override
    public Integer setState(String kno) {
        return userMapper.setState(kno);
    }

    @Override
    public Integer setresult(String sno, String kno, String state) {
        return userMapper.setresult(sno,kno,state);
    }

    @Override
    public String getresult(String sno) {
        return userMapper.getresult(sno);
    }

    @Override
    public CourseResult courseresult(String kno) {
        return userMapper.courseres(kno);
    }

    @Override
    public String getup(String sno) {
        return userMapper.getup(sno);
    }

    @Override
    public Integer savarequest(String sno, String kno, String message) {
        return userMapper.savarequest(sno,kno,message);
    }

    @Override
    public List<FullCourse> Courses() {
        return userMapper.Courses();
    }

    @Override
    public Integer PostCourse(FullCourse c) {
        return userMapper.PostCourse(c);
    }

    @Override
    public Integer PutCourse(FullCourse c) {
        return userMapper.PutCourse(c);
    }

    @Override
    public Integer DeleteCourse(String kno) {
        return userMapper.DeleteCourse(kno);
    }

    @Override
    public List<Voluntaries> GetVoluntary() {
        return userMapper.GetVoluntary();
    }

    @Override
    public List<FullStudent> GetStudents() {
        return userMapper.GetStudents();
    }

    @Override
    public Integer PostStudent(FullStudent student) {
        return  userMapper.PostStudent(student);
    }

    @Override
    public Integer PutStudent(FullStudent student) {
        return userMapper.PutStudent(student);
    }

    @Override
    public Integer DeleteStudent(String sno) {
        return userMapper.DeleteStudent(sno);
    }

    @Override
    public List<Teacher> GetTeachers() {
        return userMapper.GetTeachers();
    }

    @Override
    public Integer PostTeacher(Teacher teacher) {
        return userMapper.PostTeacher(teacher);
    }

    @Override
    public Integer PutTeacher(Teacher teacher) {
        return userMapper.PutTeacher(teacher);
    }

    @Override
    public Integer DeleteTeacher(String tno) {
        return userMapper.DeleteTeacher(tno);
    }

    @Override
    public List<Message_Online> GetMessages() {
        return userMapper.GetMessages();
    }

    @Override
    public List<ResultCourse> GetResults() {
        return userMapper.GetResults();
    }

    @Override
    public List<Message_exit> GetExits() {
        return userMapper.GetExits();
    }

    @Override
    public Integer putResult(String kno) {
        return userMapper.putResult(kno);
    }

    @Override
    public Integer putCourseStatus(String kno) {
        return userMapper.putCourseStatus(kno);
    }

    @Override
        public Integer deleteExitMessage(String kno) {
        return userMapper.deleteExitMessage(kno);
    }


}
