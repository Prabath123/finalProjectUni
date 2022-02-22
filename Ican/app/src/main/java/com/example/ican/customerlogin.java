package com.example.ican;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class customerlogin extends AppCompatActivity {

     Button but1,but2,but3;
    TextInputLayout  usn,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerlogin);

        but1=(Button) findViewById(R.id.b1);
        but2=(Button) findViewById(R.id.b2);
        but3=(Button) findViewById(R.id.login);
        usn = findViewById(R.id.username);
       pas = findViewById(R.id.password);


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencustomersignup();
            }

        });

    }

    public void opencustomersignup(){
        Intent intent = new Intent(this,insert1.class);
        startActivity(intent);
    }

    private boolean validateusername(){
        String val = usn.getEditText().getText().toString();

        if(val.isEmpty()){
            usn.setError("Field cannot be empty");
            return false;
        }
        else {
            usn.setError(null);
            usn.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatepassword(){
        String val = pas.getEditText().getText().toString();
        if (val.isEmpty()){
            pas.setError("field cannot be empty");
            return false;
        }
        else {
            pas.setError(null);
            pas.setErrorEnabled(false);
            return true;
        }

    }

    public void loginUser(View View){
        if (!validateusername() | !validatepassword()){
            return;
        }
        else {
            isUser();
        }
    }




    private void isUser() {
        String userEnterdUsername = usn.getEditText().getText().toString().trim();
        String userEnterdPassword = pas.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("customers");
        Query checkuser = reference.orderByChild("usname").equalTo(userEnterdUsername);
        checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if (snapshot.exists()){

                    usn.setError(null);
                    usn.setErrorEnabled(false);


                    String passwordDb = snapshot.child(userEnterdUsername).child("pass").getValue(String.class);

                    if (passwordDb.equals(userEnterdPassword)){

                        usn.setError(null);
                        usn.setErrorEnabled(false);


                        String idDb = snapshot.child(userEnterdUsername).child("id").getValue(String.class);
                        String nameDb = snapshot.child(userEnterdUsername).child("usname").getValue(String.class);
                        String emailDb = snapshot.child(userEnterdUsername).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),profile.class);
                        intent.putExtra("id",idDb);
                        intent.putExtra("pass",passwordDb);
                        intent.putExtra("usname",nameDb);
                        intent.putExtra("email",emailDb);

                        startActivity(intent);

                    }
                    else
                    {
                        pas.setError("wrong password");
                        pas.requestFocus();
                    }
                }
                else {
                    usn.setError("No such User exit");
                    usn.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }





}