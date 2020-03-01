package com.how2java.springboot.webentity;

public class Message_Online {
    private String sno;
    private String sname;
    private String smessage;

    @Override
    public String toString() {
        return "Message{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", smessage='" + smessage + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSmessage() {
        return smessage;
    }

    public void setSmessage(String smessage) {
        this.smessage = smessage;
    }
}
