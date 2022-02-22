package com.example.ican;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insert1 extends AppCompatActivity {

    TextInputLayout uname,passwd,gmail,nic;
    Button insertdata;

    FirebaseDatabase rootdata;
    DatabaseReference customerdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert1);

        uname= findViewById(R.id.username);
        passwd= findViewById(R.id.Password);
        gmail= findViewById(R.id.Gmail);
        nic= findViewById(R.id.NIC_NO);
        insertdata =findViewById(R.id.SignUp);


        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootdata = FirebaseDatabase.getInstance();
                customerdata = rootdata.getReference("customers");

                String name =uname.getEditText().getText().toString();
                String ps =passwd.getEditText().getText().toString();
                String email =gmail.getEditText().getText().toString();
                String id =nic.getEditText().getText().toString();

               customers cus =new customers(name, ps, email, id);
                customerdata.child(id).setValue(cus);
            }

        });

        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }

        });

    }

    public void signup(){
        Intent intent = new Intent(this,curentLocation.class);
        startActivity(intent);
    }








}

