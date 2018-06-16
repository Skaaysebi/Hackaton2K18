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
import java.io.FileOutputStream;
import java.io.FileReader;

import Model.APIConnector.APIConnector;
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
        try {
            checkIfUserIsLoggedIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkIfUserIsLoggedIn() throws Exception{
        if(fileExist("login")){
            File file = new File(getApplicationContext().getFilesDir(), "login");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String userInfo = reader.readLine();
            UserSingleton.initInstance(userInfo);
            switchToMainScreen();
        }
    }

    private void initFields() {
        username = findViewById(R.id.usernameField);
        password = findViewById(R.id.passwortField);
    }

    public void signin(View view) {
        String userNameString = username.getText().toString();
        String passWordString = password.getText().toString();

        User user = new User(userNameString, passWordString);
        User foundUser = APIConnector.getUserFromDB(user);
        if(foundUser == null) {
            Toast.makeText(getApplicationContext(), "Die Userdaten sind nicht korrekt!", Toast.LENGTH_LONG).show();
        }
        else {
            FileOutputStream outputStream;
            if(fileExist("login")){
                try {
                    StringBuffer fileContents = new StringBuffer();
                    fileContents.append(foundUser.getUsername()).append(" ")
                            .append(foundUser.getPassword()).append(" ")
                            .append(foundUser.getCardId()).append(" ")
                            .append(foundUser.isAdmin()).append(" ")
                            .append(foundUser.getAmount());
                    outputStream = openFileOutput("login", Context.MODE_PRIVATE);
                    outputStream.write(fileContents.toString().getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            switchToMainScreen();
        }
    }

    private boolean fileExist(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }


    private void switchToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
