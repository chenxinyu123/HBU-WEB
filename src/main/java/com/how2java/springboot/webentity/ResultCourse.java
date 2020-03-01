package com.how2java.springboot.webentity;

public class ResultCourse {
    private String kno;
    private String kname;
    private String state;
    private String sno;
    private String sname;

    @Override
    public String toString() {
        return "ResultCourse{" +
                "kno='" + kno + '\'' +
                ", kname='" + kname + '\'' +
                ", state='" + state + '\'' +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
