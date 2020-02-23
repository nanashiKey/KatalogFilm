package com.ngopidev.project.katalogfilm.appshelper;

import com.google.gson.annotations.SerializedName;

/**
 * created by Irfan Assidiq on 2020-02-23
 * email : assidiq.irfan@gmail.com
 **/
public class FilmModel {
    @SerializedName("image") String image;
    @SerializedName("judul_buku") String judul_buku;
    @SerializedName("nama_penulis") String nama_penulis;
    @SerializedName("description") String description;
}
