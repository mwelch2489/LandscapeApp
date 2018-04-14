package com.example.matt.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ShrubActivity extends AppCompatActivity {

    String[] shrubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrub);

        Resources res = getResources();
        shrubs = res.getStringArray(R.array.shrubs);

        ListView ShrubList = (ListView) findViewById(R.id.ShrubList);

        ListAdapter TreeActivityAdapter = new TreeActivityAdapter(this, shrubs);
        ShrubList.setAdapter(TreeActivityAdapter);

        ShrubList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
