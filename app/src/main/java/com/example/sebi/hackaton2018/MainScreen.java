package com.example.sebi.hackaton2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void switchToFree(View view){
        Intent intent = new Intent(this, FreeActivity.class);
        startActivity(intent);
    }

    public void switchToJobs(View view){
        Intent intent = new Intent(this, JobsActivity.class);
        startActivity(intent);
    }

    public void switchToRoomRent(View view){
        Intent intent = new Intent(this, roomRent.class);
        startActivity(intent);
    }

    public void switchToStatistik(View view){
        Intent intent = new Intent(this, statisticsOverview.class);
        startActivity(intent);
    }
}
