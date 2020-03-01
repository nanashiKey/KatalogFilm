package com.ngopidev.project.katalogfilm.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.GsonBuilder;
import com.ngopidev.project.katalogfilm.R;
import com.ngopidev.project.katalogfilm.adapters.KatalogFilmAdapter;
import com.ngopidev.project.katalogfilm.appshelper.AllConstanta;
import com.ngopidev.project.katalogfilm.appshelper.ApiOnly;
import com.ngopidev.project.katalogfilm.appshelper.FilmModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView rcView;
    ArrayList<FilmModel> filmModels;
    KatalogFilmAdapter adapter;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.floatingActionButton);
        rcView = findViewById(R.id.rcView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UploadActivity.class));
            }
        });

        filmModels = new ArrayList<FilmModel>();
        LinearLayoutManager llManager = new LinearLayoutManager(this,
                                        LinearLayoutManager.VERTICAL, false);
        rcView.setHasFixedSize(true);
        rcView.setLayoutManager(llManager);

        retrofit = new Retrofit.Builder().baseUrl(AllConstanta.baseurl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();

        final ApiOnly apiOnly = retrofit.create(ApiOnly.class); //digunakan untuk meng-inisiasi class apionly untuk diakses

        Call<FilmModel> getListFilm = apiOnly.getlistfilm();
        getListFilm.enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if(response.isSuccessful()){
                    FilmModel filmModel;
                    if(response.body() != null){
                         for( int x = 0; x < 10; x++){
                             filmModel = response.body();
                             filmModels.add(filmModel);
                         }
                     adapter = new KatalogFilmAdapter(MainActivity.this, filmModels);
                     rcView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logout){
            Toast.makeText(this, "button Log Out", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
