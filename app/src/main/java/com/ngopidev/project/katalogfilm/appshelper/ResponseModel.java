package com.ngopidev.project.katalogfilm.appshelper;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * created by Irfan Assidiq on 2020-02-23
 * email : assidiq.irfan@gmail.com
 **/
public class ResponseModel implements Serializable {
//    bentuk model seperti biasa di java :
//    String kode;
//
//    public String getKode() {
//        return kode;
//    }
//
//    public void setKode(String kode) {
//        this.kode = kode;
//    }

    @SerializedName("kode")  public int kode;
    @SerializedName("message") public String message;

}
