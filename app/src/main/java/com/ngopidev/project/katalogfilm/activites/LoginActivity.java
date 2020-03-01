package com.ngopidev.project.katalogfilm.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.gson.GsonBuilder;
import com.ngopidev.project.katalogfilm.R;
import com.ngopidev.project.katalogfilm.appshelper.AllConstanta;
import com.ngopidev.project.katalogfilm.appshelper.ApiOnly;
import com.ngopidev.project.katalogfilm.appshelper.PrefsHelper;
import com.ngopidev.project.katalogfilm.appshelper.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * created by Irfan Assidiq on 2020-02-16
 * email : assidiq.irfan@gmail.com
 **/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView tvRegister;
    EditText etUsername, etPassword;
    Retrofit retrofit;
    ApiOnly apiOnly;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        //inisialisasi view
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        getSupportActionBar().setTitle("LOGIN");
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.colorPrimary));

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        boolean statusLogin = PrefsHelper.sharedInstance(this).getStatusLogin();
        if(statusLogin){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        retrofit = new Retrofit.Builder().baseUrl(AllConstanta.baseurl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();

        apiOnly = retrofit.create(ApiOnly.class); //digunakan untuk meng-inisiasi class apionly untuk diakses

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogin){

            String email = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "isi kolom yang kosong", Toast.LENGTH_SHORT).show();
            }else{
                Call<ResponseModel> loginuser = apiOnly.loginuser(email, password);
                loginuser.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        ResponseModel responseModel = response.body(); // untuk mengambil data dari server
                        if(response.isSuccessful()){
                            if(responseModel != null){
                                if(responseModel.kode == 200){
                                    PrefsHelper.sharedInstance(LoginActivity.this).setStatusLogin(true);
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                }
                                Toast.makeText(LoginActivity.this,
                                        responseModel.message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "error message "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }else if(view.getId() == R.id.tvRegister){
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }else{
            Toast.makeText(this, "tidak ada button yang di klik", Toast.LENGTH_SHORT).show();
        }
    }
}
