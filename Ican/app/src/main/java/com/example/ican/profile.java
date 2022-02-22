package com.example.ican;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        showuserallData();
    }

    private void showuserallData() {

        Intent intent = getIntent();
        String name =intent.getStringExtra("uname");
        String id =intent.getStringExtra("id");
        String email =intent.getStringExtra("email");
        String phoneNo =intent.getStringExtra("PhoneNo");



    }
}