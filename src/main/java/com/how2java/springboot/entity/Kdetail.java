package com.how2java.springboot.entity;

import java.io.Serializable;

public class Kdetail implements Serializable {
    private String kcontent;
    private String ktarget;

    @Override
    public String toString() {
        return "Kdetail{" +
                "kcontent='" + kcontent + '\'' +
                ", ktarget='" + ktarget + '\'' +
                '}';
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
}
