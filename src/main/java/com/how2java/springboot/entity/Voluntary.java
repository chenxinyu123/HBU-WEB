package com.how2java.springboot.entity;

import java.io.Serializable;
public class Voluntary implements Serializable {
    private String sno;
    private String kno1;
    private String kno2;
    private String kno3;
    private String kno4;
    private String kno5;

    @Override
    public String toString() {
        return "Volutary{" +
                "sno='" + sno + '\'' +
                ", kno1='" + kno1 + '\'' +
                ", kno2='" + kno2 + '\'' +
                ", kno3='" + kno3 + '\'' +
                ", kno4='" + kno4 + '\'' +
                ", kno5='" + kno5 + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getKno1() {
        return kno1;
    }

    public void setKno1(String kno1) {
        this.kno1 = kno1;
    }

    public String getKno2() {
        return kno2;
    }

    public void setKno2(String kno2) {
        this.kno2 = kno2;
    }

    public String getKno3() {
        return kno3;
    }

    public void setKno3(String kno3) {
        this.kno3 = kno3;
    }

    public String getKno4() {
        return kno4;
    }

    public void setKno4(String kno4) {
        this.kno4 = kno4;
    }

    public String getKno5() {
        return kno5;
    }

    public void setKno5(String kno5) {
        this.kno5 = kno5;
    }
}
