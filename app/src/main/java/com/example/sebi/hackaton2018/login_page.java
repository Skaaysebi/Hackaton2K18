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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import Model.APIConnector.APIConnector;
import Model.DummyData.DummyCreator;
import Model.User;
import Model.UserSingleton;

public class login_page extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView cardId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        //TODO: delete
        Executor exec = Executors.newFixedThreadPool(3);
        exec.execute(new Runnable() {
            @Override
            public void run() {
                APIConnector.getUserFromDB(new User("blabla", "adfasd sdfsad", "cardidblabla"));
                APIConnector.getAllRooms();
                APIConnector.getAllJobsForUser("261b1d35-3c89-44d1-bfa2-676d18ec01a2");
                APIConnector.getAllEvents();
            }
        });

        initFields();
    }

    private void initFields() {
        username = findViewById(R.id.usernameField);
        password = findViewById(R.id.passwortField);
    }

    public void signin(View view) {
        String userNameString = username.getText().toString();
        String passWordString = password.getText().toString();

        User user = new User(userNameString, passWordString, "1u1huz13g61371");
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
