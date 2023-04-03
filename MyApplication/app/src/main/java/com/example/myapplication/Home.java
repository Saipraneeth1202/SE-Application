package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Home extends AppCompatActivity {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b1 = findViewById(R.id.RegisterPage);
        b2 = findViewById(R.id.StudentPage);
        b3 = findViewById(R.id.TeacherPage);
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Home.this,RegisterUser.class);
                        startActivity(i);
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Home.this,StudentHome.class);
                        startActivity(i);
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Home.this,Teacher_home.class);
                        startActivity(i);
                    }
                }
        );
    }
}