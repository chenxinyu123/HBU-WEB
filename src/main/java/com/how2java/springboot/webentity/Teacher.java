package com.how2java.springboot.webentity;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String tno;
    private String tname;
    private String tsex;
    private String ttle;
    private String temail;
    private String ttitle;

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", ttle='" + ttle + '\'' +
                ", temail='" + temail + '\'' +
                ", ttitle='" + ttitle + '\'' +
                '}';
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTtle() {
        return ttle;
    }

    public void setTtle(String ttle) {
        this.ttle = ttle;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }
}
