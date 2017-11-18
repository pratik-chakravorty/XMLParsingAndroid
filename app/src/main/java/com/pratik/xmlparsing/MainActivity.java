package com.pratik.xmlparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String [] movieNames = {"Dark Knight","Your Name","Avengers","John Wick"};

    private ListView list;
    private XMLParser parser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,movieNames);

        list.setAdapter(adapter);

        parser = new XMLParser(getApplicationContext());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this,SecondActivity.class);
                Movie data = parser.getData(position);
                mIntent.putExtra("movieTitle",data.getMovieName());
                mIntent.putExtra("movieInfo",data.getMovieInfo());
                startActivity(mIntent);
            }
        });


    }
}
