package com.example.matt.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EndActivity extends AppCompatActivity {
    String[] trees;
    String[] hardgoods;
    String[] flowers;
    String[] grass;
    String[] shrubs;
    String[] labor;
    SharedPreferences Settings;
    Context Ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Resources res = getResources();
        trees = res.getStringArray(R.array.trees);
        hardgoods = res.getStringArray(R.array.hardgoods);
        flowers = res.getStringArray(R.array.flowers);
        grass = res.getStringArray(R.array.grass);
        shrubs = res.getStringArray(R.array.shrubs);
        labor = res.getStringArray(R.array.labor);

        List <String> temp = new ArrayList<>();
        Collections.addAll(temp, trees);
        Collections.addAll(temp, hardgoods);
        Collections.addAll(temp, flowers);
        Collections.addAll(temp, grass);
        Collections.addAll(temp, shrubs);
        Collections.addAll(temp, labor);

        String[] items = temp.toArray(new String[temp.size()]);

        ListView EndList = (ListView) findViewById(R.id.EndList);

        ListAdapter EndActivityAdapter = new EndActivityAdapter(this, items);
        EndList.setAdapter(EndActivityAdapter);

        EndList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
//        SharedPreferences settings = getSharedPreferences("Saved Items", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = settings.edit();
//        editor.clear();
//        editor.commit();
    }

}