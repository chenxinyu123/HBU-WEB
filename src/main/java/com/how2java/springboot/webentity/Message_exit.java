package com.how2java.springboot.webentity;

public class Message_exit {
    private String sno;
    private String sname;
    private String kno;
    private String kname;
    private String message;

    @Override
    public String toString() {
        return "Message_exit{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", kno='" + kno + '\'' +
                ", kname='" + kname + '\'' +
                ", message='" + message + '\'' +
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
