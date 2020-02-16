package com.ngopidev.project.katalogfilm.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ngopidev.project.katalogfilm.R;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView rcView;

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
