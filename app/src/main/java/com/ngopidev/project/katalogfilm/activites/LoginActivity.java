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

import com.ngopidev.project.katalogfilm.R;


/**
 * created by Irfan Assidiq on 2020-02-16
 * email : assidiq.irfan@gmail.com
 **/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView tvRegister;
    EditText etUsername, etPassword;
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
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogin){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }else if(view.getId() == R.id.tvRegister){
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }else{
            Toast.makeText(this, "tidak ada button yang di klik", Toast.LENGTH_SHORT).show();
        }
    }
}
