package com.example.matt.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

        public class TreeActivity extends AppCompatActivity {
            String[] trees;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_tree);

                Resources res = getResources();
                trees = res.getStringArray(R.array.trees);

                ListView TreeList = (ListView) findViewById(R.id.TreeList);

                ListAdapter TreeActivityAdapter = new TreeActivityAdapter(this, trees);
                TreeList.setAdapter(TreeActivityAdapter);

                TreeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
            }

        }