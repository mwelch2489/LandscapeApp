package com.example.matt.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HardgoodsActivity extends AppCompatActivity {

    String[] hardgoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardgoods);

        Resources res = getResources();
        hardgoods = res.getStringArray(R.array.hardgoods);

        ListView HardgoodsList = (ListView) findViewById(R.id.HardgoodsList);

        ListAdapter HardgoodsActivityAdapter = new HardgoodsActivityAdapter(this, hardgoods);
        HardgoodsList.setAdapter(HardgoodsActivityAdapter);

        HardgoodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
