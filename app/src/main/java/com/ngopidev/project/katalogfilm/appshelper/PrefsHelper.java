package com.ngopidev.project.katalogfilm.appshelper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * created by Irfan Assidiq on 2020-02-23
 * email : assidiq.irfan@gmail.com
 **/
public class PrefsHelper {
    private SharedPreferences shared;
    private Context ctx;
    private String sharedName = "KatalogFILM";
    private String statusLogin = "LOGINSTAT";

    private static PrefsHelper instance;

    public static PrefsHelper sharedInstance(Context ctx){
        if(instance == null){
            instance = new PrefsHelper(ctx);
        }
        return  instance;
    }
    private PrefsHelper(Context ctx){
        this.ctx = ctx;
        this.shared = ctx.getSharedPreferences(sharedName, Context.MODE_PRIVATE);
    }

    public void setStatusLogin(boolean status){
        SharedPreferences.Editor editor = shared.edit();
        editor.putBoolean(statusLogin, status);
        editor.apply();
    }

    public boolean getStatusLogin(){
        return shared.getBoolean(statusLogin, false);
    }

}
