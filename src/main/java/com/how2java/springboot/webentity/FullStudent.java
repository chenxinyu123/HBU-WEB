package com.how2java.springboot.webentity;

public class FullStudent {
    private String sno;
    private String sname;
    private String sclass;
    private String sgender;
    private String sbirth;
    private String semail;
    private String stel;
    private String susername;
    private String spassword;

    @Override
    public String toString() {
        return "FullStudent{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sbirth='" + sbirth + '\'' +
                ", semail='" + semail + '\'' +
                ", stel='" + stel + '\'' +
                ", susername='" + susername + '\'' +
                ", spassword='" + spassword + '\'' +
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

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public String getSbirth() {
        return sbirth;
    }

    public void setSbirth(String sbirth) {
        this.sbirth = sbirth;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }
}
