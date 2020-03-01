package com.how2java.springboot.service;

import com.how2java.springboot.entity.*;
import com.how2java.springboot.webentity.*;

import java.util.List;


public interface UserService {

    String findById(String u, String p);
    Student student(String username);
    Teacher teacher(String username);
    Integer xiugai(String username, String password, String newpassword);
    Integer setperson(Student student);
    List<Course> findProject(String kclass, int start, int laststart);
    List<Course> findProject2(String kclass, int start, int laststart, String type);
    Kdetail content(String Kno);
    Voluntary serchVoluntary(String sno);

    Course lookvoluntary(String kno);
    Integer addvoluntary(Voluntary voluntary);
    Integer deletevoluntary(Voluntary voluntary);
    Integer savamessage(String Sno,String Message);

    List<Voluntary> getVoluntary();

    String getState(String kno);

    Integer setState(String kno);

    Integer setresult(String sno, String kno1, String yes);

    String getresult(String sno);

    CourseResult courseresult(String kno);

    String getup(String sno);

    Integer savarequest(String sno, String kno, String message);

    List<FullCourse> Courses();

    Integer PostCourse(FullCourse c);

    Integer PutCourse(FullCourse c);

    Integer DeleteCourse(String kno);

    List<Voluntaries> GetVoluntary();

    List<FullStudent> GetStudents();

    Integer PostStudent(FullStudent student);

    Integer PutStudent(FullStudent student);

    Integer DeleteStudent(String sno);

    List<Teacher> GetTeachers();

    Integer PostTeacher(Teacher teacher);

    Integer PutTeacher(Teacher teacher);


    Integer DeleteTeacher(String tno);

    List<Message_Online> GetMessages();

    List<ResultCourse> GetResults();

    List<Message_exit> GetExits();


    Integer putResult(String kno);

    Integer putCourseStatus(String kno);

    Integer deleteExitMessage(String kno);
}
