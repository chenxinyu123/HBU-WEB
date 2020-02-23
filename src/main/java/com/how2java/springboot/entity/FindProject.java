package com.how2java.springboot.entity;

import java.io.Serializable;

public class FindProject implements Serializable {
    private String kno;
    private String kname;
    private Teacher teacher;
    private String kstatus;
    private String kclass;

    @Override
    public String toString() {
        return "FindProject{" +
                "kno='" + kno + '\'' +
                ", kname='" + kname + '\'' +
                ", teacher=" + teacher +
                ", kstatus='" + kstatus + '\'' +
                ", kclass='" + kclass + '\'' +
                '}';
    }

    public String getKno() {
        return kno;
    }

    public void setKno(String kno) {
        this.kno = kno;
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

    public String getKstatus() {
        return kstatus;
    }

    public void setKstatus(String kstatus) {
        this.kstatus = kstatus;
    }

    public String getKclass() {
        return kclass;
    }

    public void setKclass(String kclass) {
        this.kclass = kclass;
    }
}
