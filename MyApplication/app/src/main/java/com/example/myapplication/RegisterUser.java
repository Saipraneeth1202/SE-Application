package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class RegisterUser extends AppCompatActivity {

    Button Submit;
    EditText Course, RegNo, Name, MobNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        Course = findViewById(R.id.Course);
        RegNo = findViewById(R.id.RegNo);
        Name = findViewById(R.id.Name);
        MobNo = findViewById(R.id.MobNo);
        Submit = findViewById(R.id.submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });
    }

    public void uploadData(){

        String course = Course.getText().toString();
        String reg = RegNo.getText().toString();
        String name = Name.getText().toString();
        String mob = MobNo.getText().toString();

        RegData data = new RegData(course, reg, name, mob);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("APP DATA").child(currentDate)
                .setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText( RegisterUser.this, "Saved", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterUser.this,StudentHome.class);
                            startActivity(i);
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterUser.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}