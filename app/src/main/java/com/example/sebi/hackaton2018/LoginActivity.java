package com.example.sebi.hackaton2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Model.APIConnector.APIConnector;
import Model.User;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView showError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        }
    }

    private void initFields() {
        //username = findViewById(R.id.username);
        //password = findViewById(R.id.password);
        //showError = findViewById(R.id.showError);
    }

    public void checkOut(View view){
        String userNameString = (String) username.getText();
        String passWordString = (String) password.getText();

        User user = new User(userNameString, passWordString);
        User foundUser = APIConnector.getUserFromDB(user);
        if(foundUser == null) {
            //Set Error message
        }
        else {
            switchToMainActivity();
        }
    }

    private boolean fileExist(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }


    private void switchToMainActivity() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }

}
