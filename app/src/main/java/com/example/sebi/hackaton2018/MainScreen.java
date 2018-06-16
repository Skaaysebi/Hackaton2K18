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

        //öffne FreeActivity
        ImageView freeActivity = (ImageView) findViewById(R.id.free);
        freeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFreeActivity();
            }
        });
    }



    private void openFreeActivity(){
        Intent intent = new Intent(this, FreeActivity.class);
        startActivity(intent);
    }
}
