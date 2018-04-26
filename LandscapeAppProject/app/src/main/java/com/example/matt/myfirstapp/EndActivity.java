package com.example.matt.myfirstapp;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    TextView endList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView endList = (TextView) findViewById(R.id.EndList);

    }

    public void displayEstimateItems(View view){
        SharedPreferences settings = getSharedPreferences("SavedItems", 0);

        String estimateItems =  settings.getString("SavedItems", "No Items Were Selected");
        endList.setText(estimateItems);
    }
}
