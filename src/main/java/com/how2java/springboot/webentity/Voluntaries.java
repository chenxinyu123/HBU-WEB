package com.how2java.springboot.webentity;

public class Voluntaries {
    private String sname;
    private String kname1;
    private String kname2;
    private String kname3;
    private String kname4;
    private String kname5;

    @Override
    public String toString() {
        return "Voluntarys{" +
                "sname='" + sname + '\'' +
                ", kname1='" + kname1 + '\'' +
                ", kname2='" + kname2 + '\'' +
                ", kname3='" + kname3 + '\'' +
                ", kname4='" + kname4 + '\'' +
                ", kname5='" + kname5 + '\'' +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getKname1() {
        return kname1;
    }

    public void setKname1(String kname1) {
        this.kname1 = kname1;
    }

    public String getKname2() {
        return kname2;
    }

    public void setKname2(String kname2) {
        this.kname2 = kname2;
    }

    public String getKname3() {
        return kname3;
    }

    public void setKname3(String kname3) {
        this.kname3 = kname3;
    }

    public String getKname4() {
        return kname4;
    }

    public void setKname4(String kname4) {
        this.kname4 = kname4;
    }

    public String getKname5() {
        return kname5;
    }

    public void setKname5(String kname5) {
        this.kname5 = kname5;
    }
}
