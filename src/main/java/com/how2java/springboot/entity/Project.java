package com.how2java.springboot.entity;

import java.io.Serializable;

public class Project implements Serializable {

    private String kno;
    private String kname;
    private String tno;
    private String kstatus;
    private String kclass;

    @Override
    public String toString() {
        return "Project{" +
                "kno='" + kno + '\'' +
                ", kname='" + kname + '\'' +
                ", tno='" + tno + '\'' +
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

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
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