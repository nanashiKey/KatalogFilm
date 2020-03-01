package com.ngopidev.project.katalogfilm.appshelper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * created by Irfan Assidiq on 2020-02-23
 * email : assidiq.irfan@gmail.com
 **/
public class FilmModel implements Serializable {
    @Expose
    @SerializedName("image") public String image;

    @Expose
    @SerializedName("judul_buku") public String judul_buku;

    @Expose
    @SerializedName("nama_penulis") public String nama_penulis;

    @Expose
    @SerializedName("description") public String description;
}
