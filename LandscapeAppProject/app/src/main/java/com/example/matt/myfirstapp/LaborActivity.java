package com.example.matt.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LaborActivity extends AppCompatActivity {

    String[] labor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor);

        Resources res = getResources();
        labor = res.getStringArray(R.array.labor);

        ListView LaborList = (ListView) findViewById(R.id.LaborList);

        ListAdapter LaborActivityAdapter = new LaborActivityAdapter(this, labor);
        LaborList.setAdapter(LaborActivityAdapter);

        LaborList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
