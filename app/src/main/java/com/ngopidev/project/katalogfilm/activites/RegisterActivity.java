package com.ngopidev.project.katalogfilm.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ngopidev.project.katalogfilm.R;
import com.ngopidev.project.katalogfilm.appshelper.AllConstanta;
import com.ngopidev.project.katalogfilm.appshelper.ApiOnly;
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
public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etEmail, etPassword, etConfirmPassword;
    Button btn_regis;
    Retrofit retrofit;
    ResponseModel responseModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_register);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etConfirmPassword = findViewById(R.id.etConfirmPass);
        btn_regis = findViewById(R.id.btnRegis);

        retrofit = new Retrofit.Builder().baseUrl(AllConstanta.baseurl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();

        final ApiOnly apiOnly = retrofit.create(ApiOnly.class); //digunakan untuk meng-inisiasi class apionly untuk diakses

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPass = etConfirmPassword.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                responseModel = new ResponseModel(); // untuk mengambil response model

                if(!username.isEmpty() || !password.isEmpty() || !confirmPass.isEmpty() || !email.isEmpty()){
                    if(password.equals(confirmPass)){
                        Call<ResponseModel> registeruser = apiOnly.registeruser(username, email, password);
                        registeruser.enqueue(new Callback<ResponseModel>() {
                            @Override
                            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                if(response.isSuccessful()){
                                    responseModel = response.body();
                                    if (responseModel.kode == 200){
                                        Toast.makeText(RegisterActivity.this, responseModel.message, Toast.LENGTH_SHORT).show();
                                        finish();
                                    }else{
                                        Toast.makeText(RegisterActivity.this, responseModel.message, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseModel> call, Throwable t) {
                                Toast.makeText(RegisterActivity.this, "error message "+t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        Toast.makeText(RegisterActivity.this, "password tidak sesuai", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "mohon isi setiap kolom kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
