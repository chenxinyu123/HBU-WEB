package com.how2java.springboot.webentity;

public class FullCourse {

    private String kno;
    private String kname;
    private String tno;
    private String kstatus;
    private String kclass;
    private String kcontent;
    private String ktarget;
    private String ktype;

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

    public String getKcontent() {
        return kcontent;
    }

    public void setKcontent(String kcontent) {
        this.kcontent = kcontent;
    }

    public String getKtarget() {
        return ktarget;
    }

    public void setKtarget(String ktarget) {
        this.ktarget = ktarget;
    }

    public String getKtype() {
        return ktype;
    }

    public void setKtype(String ktype) {
        this.ktype = ktype;
    }

    @Override
    public String toString() {
        return "FullCourse{" +
                "kno='" + kno + '\'' +
                ", kname='" + kname + '\'' +
                ", tno='" + tno + '\'' +
                ", kstatus='" + kstatus + '\'' +
                ", kclass='" + kclass + '\'' +
                ", kcontent='" + kcontent + '\'' +
                ", ktarget='" + ktarget + '\'' +
                ", ktype='" + ktype + '\'' +
                '}';
    }
}
