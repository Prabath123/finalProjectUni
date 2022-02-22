package com.example.ican;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class chose extends AppCompatActivity {
    ImageView ve;
    TextView a;
    Animation an2,an1;
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);

        an1= AnimationUtils.loadAnimation(this,R.anim.vehicle);
        an2= AnimationUtils.loadAnimation(this,R.anim.vehic);

        ve=findViewById(R.id.car);
        a = findViewById(R.id.t1);

        ve.setAnimation(an2);

        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencustomerlogin();
            }




        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensupporterlogin();
            }


        });



    }

    public void opencustomerlogin(){
        Intent intent = new Intent(this,customerlogin.class);
        startActivity(intent);

    }

    public void opensupporterlogin(){
        Intent intent = new Intent(this,curentLocation.class);
        startActivity(intent);

    }
}