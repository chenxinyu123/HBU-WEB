package com.how2java.springboot.controller;


import com.google.gson.Gson;
import com.how2java.springboot.entity.*;
import com.how2java.springboot.service.UserService;
import com.how2java.springboot.webentity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloController {
    @Autowired
    UserService userService;

    //登录接口
    @GetMapping("/session")
    public Student login(@RequestParam("username") String username,
                         @RequestParam("password") String password) {

        System.out.println(username);
        System.out.println(password);

        String id = userService.findById(username, password);


        if (id == null) {
            return null;
        }
        return userService.student(id);
    }

    //修改密码接口

    @PutMapping(value = "/session")
    public String putSession(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("npassword") String npassword
    ) {

        System.out.println(username);
        System.out.println(password);
        System.out.println(npassword);
        Integer xiugai = userService.xiugai(username, password, npassword);
        System.out.println(xiugai);
        if (xiugai == 1) {
            return "Successed";
        }
        return "error";
    }

    //修改个人信息接口
    @PutMapping("/student")
    public String setStudent(@RequestParam("student") String student) {
        System.out.println(student);
        Student s = new Gson().fromJson(student, Student.class);
        System.out.println(s.toString());
        Integer setperson = userService.setperson(s);
        if (setperson == 1) {
            return "Successed";
        }

        return "error";
    }


    //查看学生信息接口
    @GetMapping("/student")
    public Student student(@RequestParam("username") String username) {
        System.out.println(username);
        return userService.student(username);
    }
    //查看教师信息
    @GetMapping("/teacher")
    public Teacher teacher(@RequestParam("username") String username) {
        System.out.println(username);
        return userService.teacher(username);
    }

    //首页课题查看接口
    @GetMapping("/courses")
    public List<Course> courses(@RequestParam("kclass") String kclass, @RequestParam("start") String start, @RequestParam("laststart") String laststart, @RequestParam("type") String type) {
        System.out.println(kclass + "---" + start + "---" + laststart);
        int s = Integer.parseInt(start);
        int ls = Integer.parseInt(laststart);

        if (type.equals("recommend")) {
            return userService.findProject(kclass, s, ls);
        } else {
            return userService.findProject2(kclass, s, ls, type);
        }


    }

    //课程内容信息接口
    @GetMapping("/content")
    public Kdetail getContent(@RequestParam("kno") String kno) {
        System.out.println(kno);
        return userService.content(kno);
    }

    //添加志愿接口
    @PostMapping("voluntary")
    public String postvoluntary(@RequestParam("uid") String sno, @RequestParam("kno") String kno) {
        System.out.println("sno_____" + sno + "kno____" + kno);
        Voluntary voluntary = userService.serchVoluntary(sno);
        try {
            if (voluntary.getKno1().equals(kno) ||
                    voluntary.getKno2().equals(kno) ||
                    voluntary.getKno3().equals(kno) ||
                    voluntary.getKno4().equals(kno) ||
                    voluntary.getKno5().equals(kno)) {
                return "added";
            }
        } catch (Exception e) {

        }

        if (voluntary.getKno1() == null) {
            voluntary.setKno1(kno);
            return userService.addvoluntary(voluntary) + "";
        } else if (voluntary.getKno2() == null) {
            voluntary.setKno2(kno);
            return userService.addvoluntary(voluntary) + "";
        } else if (voluntary.getKno3() == null) {
            voluntary.setKno3(kno);
            return userService.addvoluntary(voluntary) + "";
        } else if (voluntary.getKno4() == null) {
            voluntary.setKno4(kno);
            return userService.addvoluntary(voluntary) + "";
        } else if (voluntary.getKno5() == null) {
            voluntary.setKno5(kno);
            return userService.addvoluntary(voluntary) + "";
        }
        return "full";
    }

    //查看志愿接口
    @GetMapping("/voluntary")
    public List<Course> getVoluntary(@RequestParam("uid") String sno) {
        Voluntary voluntary = userService.serchVoluntary(sno);
        System.out.println(voluntary.toString());
        List<Course> projects = new ArrayList<>(5);
        try {
            projects.add(userService.lookvoluntary(voluntary.getKno1()));
            projects.add(userService.lookvoluntary(voluntary.getKno2()));
            projects.add(userService.lookvoluntary(voluntary.getKno3()));
            projects.add(userService.lookvoluntary(voluntary.getKno4()));
            projects.add(userService.lookvoluntary(voluntary.getKno5()));
        } catch (Exception e) {

        }

        return projects;
    }

    //删除志愿接口
    @PutMapping("/voluntary")
    public String deletevoluntary(@RequestParam("voluntary") String voluntary) {
        Gson gson = new Gson();
        Voluntary v = gson.fromJson(voluntary, Voluntary.class);
        try {
            System.out.println(v.toString());
            return userService.deletevoluntary(v) + "";
        } catch (Exception e) {

        }
        return "error";


    }

    //在线留言接口
    @PostMapping("/message")
    public String postMessage(@RequestParam("Sno") String sno, @RequestParam("Message") String message) {
        System.out.println(sno + message);
        Integer savamessage = userService.savamessage(sno, message);
        if (savamessage == 1) {
            return "message";
        }

        return "error";
    }




    //查看选课结果
    @GetMapping("/result")
    public CourseResult getResult(@RequestParam("Sno") String sno){
        System.out.println(sno);
        String kno = userService.getresult(sno);
        if (kno!=null){
            return userService.courseresult(kno);
        }else return null;
    }
    //查询选课课题号
    @GetMapping("/exit/kno")
    public String getResultKno(@RequestParam("Sno") String sno){
        return userService.getup(sno);
    }
    //退课
    @PutMapping("/exit")
    public String putExit(@RequestParam("Sno") String sno, @RequestParam("Kno") String kno, @RequestParam("Message") String message){
        System.out.println("Sno---->"+sno+"Kno---->"+kno+"Msg---->"+message);
        Integer m=userService.savarequest(sno,kno,message);
        if (m == 1) {
            return "message";
        }

        return "error";
    }

    /*
    开始选题接口
     */
    //选题接口
    @GetMapping("/v2/course/select")
    public String courseSelect() {
        List<Voluntary> voluntaries = userService.getVoluntary();
        int size = voluntaries.size();
        try {

            for (int i = 0; i < size; i++) {
                int ran = (int) (Math.random() * (voluntaries.size()));
                Voluntary voluntary = voluntaries.remove(ran);
                boolean course = getCourse(voluntary);
                voluntary.setKno1(null);
                voluntary.setKno2(null);
                voluntary.setKno3(null);
                voluntary.setKno4(null);
                voluntary.setKno5(null);
                userService.deletevoluntary(voluntary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "successed";
    }
    //相对公平的选课算法--随机
    private boolean getCourse(Voluntary voluntary) throws Exception {

        String sno = voluntary.getSno();
        String kno1 = voluntary.getKno1();
        if (kno1 != null) {
            String state = userService.getState(kno1);
            if (state.equals("未选中")) {
                Integer integer = userService.setState(kno1);
                Integer yes = userService.setresult(sno, kno1, "yes");
                System.out.println(yes + "----->" + integer);
                return true;
            }
        }
        String kno2 = voluntary.getKno2();
        if (kno2 != null) {
            String state = userService.getState(kno2);
            if (state.equals("未选中")) {
                Integer integer = userService.setState(kno2);
                userService.setresult(sno, kno2, "yes");
                return true;
            }
        }
        String kno3 = voluntary.getKno3();
        if (kno3 != null) {
            String state = userService.getState(kno3);
            if (state.equals("未选中")) {
                userService.setState(kno3);
                userService.setresult(sno, kno3, "yes");
                return true;
            }
        }
        String kno4 = voluntary.getKno4();
        if (kno4 != null) {
            String state = userService.getState(kno4);
            if (state.equals("未选中")) {
                userService.setState(kno4);
                Integer yes = userService.setresult(sno, kno4, "yes");
                return true;
            }
        }
        String kno5 = voluntary.getKno5();
        if (kno5 != null) {
            String state = userService.getState(kno5);
            if (state.equals("未选中")) {
                userService.setState(kno5);
                userService.setresult(sno, kno5, "yes");
                return true;
            }
        }
        return false;
    }



    /*
    //课程管理
     */
    //查看课程
    @GetMapping("/v2/courses")
    public List<FullCourse> courses(){
        System.out.println("Courses");
        return userService.Courses();
    }
    //添加课程
    @PostMapping("v2/course")
    public Respone postCourse(@RequestParam("course")String course){
        System.out.println("PostCourse");
        if (userService.PostCourse(new Gson().fromJson(course, FullCourse.class))==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"Not Successed");
    }

    //修改课程
    @PutMapping("v2/course")
    public Respone putCourse(@RequestParam("course")String course){
        System.out.println("PutCourse");
        if (userService.PutCourse(new Gson().fromJson(course, FullCourse.class))==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"error");
    }

    //删除课程
    @DeleteMapping("v2/course")
    public Respone deleteCourse(@RequestParam("kno")String kno){
        System.out.println("DeleteCourse");
        if (userService.DeleteCourse(kno)==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"error");
    }
    /*
    //查看志愿单
     */
    //查看查看志愿单
    @GetMapping("/v2/voluntaries")
    public List<Voluntaries> getVoluntary(){
        System.out.println("GetVoluntary");
        return userService.GetVoluntary();
    }

    /*
   //学生信息管理
    */
    //查看学生信息
    @GetMapping("/v2/students")
    public List<FullStudent> getStudents(){
        System.out.println("GetStudents");
        return userService.GetStudents();
    }
    //添加学生信息
    @PostMapping("v2/student")
    public Respone postStudent(@RequestParam("student")String student){
        System.out.println("PostStudent");
        if (userService.PostStudent(new Gson().fromJson(student, FullStudent.class))==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"Not Successed");
    }
    //修改学生信息
    @PutMapping("v2/student")
    public Respone putStudent(@RequestParam("student")String student){
        System.out.println("PutStudent");
        if (userService.PutStudent(new Gson().fromJson(student, FullStudent.class))==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"Not Successed");
    }

    //删除学生信息
    @DeleteMapping("v2/student")
    public Respone deleteStudent(@RequestParam("sno")String sno){
        System.out.println("DeleteStudent");
        if (userService.DeleteStudent(sno)==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"error");
    }


    /*
   //教师信息管理
    */
    //查看教师
    @GetMapping("/v2/teachers")
    public List<Teacher> getTeachers(){
        System.out.println("GetTeachers");
        return userService.GetTeachers();
    }
    //添加学生信息
    @PostMapping("v2/teacher")
    public Respone postTeacher(@RequestParam("student")String teacher){
        System.out.println("PostStudent");
        if (userService.PostTeacher(new Gson().fromJson(teacher, Teacher.class))==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"Not Successed");
    }
    //修改学生信息
    @PutMapping("v2/teacher")
    public Respone putTeacher(@RequestParam("student")String teacher){
        System.out.println("PutTeacher");
        if (userService.PutTeacher(new Gson().fromJson(teacher, Teacher.class))==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"Not Successed");
    }

    //删除学生信息
    @DeleteMapping("v2/teacher")
    public Respone deleteTeacher(@RequestParam("Tno")String tno){
        System.out.println("DeleteTeacher");
        if (userService.DeleteTeacher(tno)==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"error");
    }



    /*
    留言信息
     */
    //查看学生留言信息
    @GetMapping("/v2/messages")
    public List<Message_Online> getMessages(){
        System.out.println("GetMessages");
        return userService.GetMessages();

    }
    /*
    选课结果
     */


    //查看选课结果
    @GetMapping("/v2/results")
    public List<ResultCourse> getResults(){
        return userService.GetResults();
    }
    /*
      退课信息
         */
    //查看学生退课信息
    @GetMapping("/v2/exits")
    public List<Message_exit> getExits(){
        System.out.println("GetMessages");
        return userService.GetExits();
    }

    //同意退课申请
    @PutMapping("v2/result")
    public Respone putResult(@Param("kno")String kno){
        //修改result表
        Integer integer=userService.putResult(kno);
        //修改课表的kstatus为未选中
        Integer integer1=userService.putCourseStatus(kno);
        //删除exit表的kno记录
        Integer integer2=userService.deleteExitMessage(kno);
        if (integer*integer1*integer2==1){
            return new SuccessCode(200,"OK","Successed");
        }else
            return new ErrorCode(404,"error");
    }








}