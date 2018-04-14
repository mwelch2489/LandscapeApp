package com.example.matt.myfirstapp;

import android.app.ListActivity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.List;

public class FlowersActivity extends AppCompatActivity {


    String[] flower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);

        Resources res = getResources();
        flower = res.getStringArray(R.array.flowers);

        ListView FlowerList = (ListView) findViewById(R.id.FlowerList);

        ListAdapter FlowerActivityAdapter = new FlowerActivityAdapter(this, flower);
        FlowerList.setAdapter(FlowerActivityAdapter);

        FlowerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
