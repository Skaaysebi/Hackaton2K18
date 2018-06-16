package com.example.sebi.hackaton2018;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import Model.APIConnector.APIConnector;
import Model.DummyData.DummyCreator;
import Model.User;
import Model.UserSingleton;

public class login_page extends AppCompatActivity {

    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        initFields();
    }

    private void initFields() {
        username = findViewById(R.id.usernameField);
        password = findViewById(R.id.passwortField);
    }

    public void signin(View view) {
        String userNameString = username.getText().toString();
        String passWordString = password.getText().toString();

        User user = new User(userNameString, passWordString, "253674859");
        //User foundUser = APIConnector.getUserFromDB(user);
        User foundUser = DummyCreator.getUser();
        if(foundUser == null) {
            Toast.makeText(getApplicationContext(), "Die Userdaten sind nicht korrekt!", Toast.LENGTH_LONG).show();
        }
        else {
            UserSingleton.initInstance(foundUser);
            }
            switchToMainScreen();
    }


    private void switchToMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void switchToRegister(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}
