package com.how2java.springboot.controller;


import com.google.gson.Gson;
import com.how2java.springboot.entity.*;
import com.how2java.springboot.service.UserService;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloController {
    @Autowired
    UserService userService;

    //登录接口
    @RequestMapping("/select/login" )
    public Student login(@RequestParam("username") String username,
                        @RequestParam("password")String password){

        System.out.println(username);
        System.out.println(password);
        User user = null;
        try {
             user = userService.findById(username, password);
        }catch (Exception e){
            e.getMessage();
        }
        
        if (user==null){
            return null;
        }
        return userService.student(user.getSno());
    }

    //修改密码接口
    @RequestMapping("/select/setpassword" )
    public String setpassword(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                         @RequestParam("npassword")String npassword
    ){

        System.out.println(username);
        System.out.println(password);
        System.out.println(npassword);
        Integer xiugai = userService.xiugai(username, password, npassword);
        System.out.println(xiugai);
        if (xiugai==1){
            return "Successed";
        }
        return "error";
    }
    //修改个人信息接口
    @RequestMapping("/select/setperson")
    public String setperson(@RequestParam("student") String student){
        System.out.println(student);
        Student s = new Gson().fromJson(student, Student.class);
        System.out.println(s.toString());
        Integer setperson = userService.setperson(s);
        if (setperson==1){
            return "Successed";
        }

        return "error";
    }




    //查看学生信息接口
    @RequestMapping("/select/student")
    public Student student(@RequestParam("username") String username){
        System.out.println(username);
        return userService.student(username);
    }

    @RequestMapping("/select/teacher")
    public Teacher teacher(@RequestParam("username") String username){
        System.out.println(username);
        return userService.teacher(username);
    }

    //首页课题查看接口
    @RequestMapping("/select/findproject")
    public List<FindProject> project(@RequestParam("kclass")String kclass,@RequestParam("start")String start,@RequestParam("laststart")String laststart,@RequestParam("type")String type){
        System.out.println(kclass+"---"+start+"---"+laststart);
        int s=Integer.parseInt(start);
        int ls=Integer.parseInt(laststart);

        if (type.equals("recommend")){
            return userService.findProject(kclass,s,ls);
        }else
        {
            return userService.findProject2(kclass,s,ls,type);
        }


    }
    //课程内容信息接口
    @RequestMapping("/select/content")
    public Kdetail getcontent(@RequestParam("kno")String kno){
        System.out.println(kno);
        return userService.content(kno);
    }

    //添加志愿接口
    @RequestMapping("/select/addvoluntary")
    public String addvoluntary(@RequestParam("uid")String sno,@RequestParam("kno")String kno){
        System.out.println("sno_____"+sno+"kno____"+kno);
        Voluntary voluntary = userService.serchVoluntary(sno);
        try {
            if (voluntary.getKno1().equals(kno)||
                    voluntary.getKno2().equals(kno)||
                    voluntary.getKno3().equals(kno)||
                    voluntary.getKno4().equals(kno)||
                    voluntary.getKno5().equals(kno)){
                return "added";
            }
        }catch (Exception e){

        }

        if (voluntary.getKno1()==null){
            voluntary.setKno1(kno);
            return userService.addvoluntary(voluntary)+"";
        }else if (voluntary.getKno2()==null){
            voluntary.setKno2(kno);
            return userService.addvoluntary(voluntary)+"";
        }else if (voluntary.getKno3()==null){
            voluntary.setKno3(kno);
            return userService.addvoluntary(voluntary)+"";
        }else if (voluntary.getKno4()==null){
            voluntary.setKno4(kno);
            return userService.addvoluntary(voluntary)+"";
        }else if (voluntary.getKno5()==null){
            voluntary.setKno5(kno);
            return userService.addvoluntary(voluntary)+"";
        }
        return "full";
    }
    //查看志愿接口
    @RequestMapping("/select/lookvoluntary")
    public List<FindProject> serchvoluntary(@RequestParam("uid")String sno){
        Voluntary voluntary = userService.serchVoluntary(sno);
        System.out.println(voluntary.toString());
        List<FindProject> projects=new ArrayList<>(5);
        try {
            projects.add(userService.lookvoluntary(voluntary.getKno1()));
            projects.add(userService.lookvoluntary(voluntary.getKno2()));
            projects.add(userService.lookvoluntary(voluntary.getKno3()));
            projects.add(userService.lookvoluntary(voluntary.getKno4()));
            projects.add(userService.lookvoluntary(voluntary.getKno5()));
        }catch (Exception e){

        }

        return projects;
    }
    //删除志愿接口
    @RequestMapping("/select/deletevoluntary")
    public String deletevoluntary(@RequestParam("voluntary")String voluntary){
        Gson gson = new Gson();
        Voluntary v = gson.fromJson(voluntary, Voluntary.class);
        try{
            System.out.println(v.toString());
            return userService.deletevoluntary(v)+"";
        }catch (Exception e){

        }
        return "error";


    }
    //在线留言接口
    @RequestMapping("/select/sendmessage")
    public String  sendmessage(@RequestParam("Sno")String sno, @RequestParam("Message")String message)
    {
        System.out.println(sno+message);
        Integer savamessage = userService.savamessage(sno, message);
        if (savamessage==1){
            return "message";
        }

        return "error";
    }

}