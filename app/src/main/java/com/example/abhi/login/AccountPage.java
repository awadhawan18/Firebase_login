package com.example.abhi.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountPage extends AppCompatActivity {
    Button logout;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private TextView hello;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);


        hello = findViewById(R.id.hello);
        logout = (Button)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.abhi.signup.Logout");
                startActivity(intent);
                hello.setText("User not logged in");

            }
        });

        try{
            email = getIntent().getStringExtra("email");

            if(email.equals("abc")){
                hello.setText("User not logged in");
                logout.setVisibility(View.INVISIBLE);

            }else{
                hello.setText("Hello, ".concat(email));
            }

        }catch (NullPointerException e){
            Log.v("Account_page",e.toString());
        }






    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
