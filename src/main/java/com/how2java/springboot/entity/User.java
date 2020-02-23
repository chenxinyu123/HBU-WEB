package com.how2java.springboot.entity;

import java.io.Serializable;

public class User implements Serializable {

    private String Uname;
    private String Upassword;
    private String Sno;

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    @Override
    public String toString() {
        return "User{" +
                "Uname='" + Uname + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Sno='" + Sno + '\'' +
                '}';
    }
}
