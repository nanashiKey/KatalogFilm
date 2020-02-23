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
}
