package com.example.matt.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class GrassActivity extends AppCompatActivity {

    String[] grass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grass);

        Resources res = getResources();
        grass = res.getStringArray(R.array.grass);

        ListView GrassList = (ListView) findViewById(R.id.GrassList);

        ListAdapter GrassActivityAdapter = new GrassActivityAdapter(this, grass);
        GrassList.setAdapter(GrassActivityAdapter);

        GrassList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
