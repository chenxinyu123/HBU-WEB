package com.how2java.springboot.entity;

import java.io.Serializable;

public class Kecheng implements Serializable {
    private String Sno;
    private String Sname;
    private String Stitle;
    private String Steacher;
    private String Sstatus;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getStitle() {
        return Stitle;
    }

    public void setStitle(String stitle) {
        Stitle = stitle;
    }

    public String getSteacher() {
        return Steacher;
    }

    public void setSteacher(String steacher) {
        Steacher = steacher;
    }

    public String getSstatus() {
        return Sstatus;
    }

    public void setSstatus(String sstatus) {
        Sstatus = sstatus;
    }
}
