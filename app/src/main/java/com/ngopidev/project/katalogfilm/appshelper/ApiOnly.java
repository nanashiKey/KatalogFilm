package com.ngopidev.project.katalogfilm.appshelper;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * created by Irfan Assidiq on 2020-02-23
 * email : assidiq.irfan@gmail.com
 **/
public interface ApiOnly {
    //untuk login
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseModel> loginuser(@Field("email") String email,
                                  @Field("password") String password);

    //untuk register
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseModel> registeruser(@Field("username") String username,
                                     @Field("email") String email,
                                     @Field("password") String password);

    //mengambil data dari server untuk data film
    @GET("listfilm.php")
    Call<FilmModel> getlistfilm();

    //mengambil data dari server untuk detail film
    @GET("listfilmbyid.php")
    Call<FilmModel> getlistfilmbyId();

    //untuk upload data film
    @FormUrlEncoded
    @POST("upload.php")
    Call<ResponseModel> uploadFilm();

}
