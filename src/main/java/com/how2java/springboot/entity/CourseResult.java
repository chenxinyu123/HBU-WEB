package com.how2java.springboot.entity;

import com.how2java.springboot.webentity.Teacher;

import java.io.Serializable;

public class CourseResult implements Serializable {
    private String kname;
    private Teacher teacher;
    private String kcontent;
    private String ktarget;

    @Override
    public String toString() {
        return "Result{" +
                "kname='" + kname + '\'' +
                ", teacher=" + teacher +
                ", kcontent='" + kcontent + '\'' +
                ", ktarget='" + ktarget + '\'' +
                '}';
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getKcontent() {
        return kcontent;
    }

    public void setKcontent(String kcontent) {
        this.kcontent = kcontent;
    }

    public String getKtarget() {
        return ktarget;
    }

    public void setKtarget(String ktarget) {
        this.ktarget = ktarget;
    }
}
