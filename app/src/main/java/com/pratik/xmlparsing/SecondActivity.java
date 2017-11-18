package com.pratik.xmlparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView movieName,movieInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        movieName = findViewById(R.id.movieName);
        movieInfo = findViewById(R.id.info);

        Intent intent = getIntent();

        String title = intent.getStringExtra("movieTitle");
        String info = intent.getStringExtra("movieInfo");

        movieName.setText(title);
        movieInfo.setText(info);


    }
}
