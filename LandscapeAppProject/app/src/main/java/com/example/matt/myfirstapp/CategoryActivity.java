package com.example.matt.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
    }
    public void sendMessageTree(View view) {
        Intent intent = new Intent(CategoryActivity.this, TreeActivity.class);
        startActivity(intent);
    }
    public void sendMessageShrubs(View view) {
        Intent intent = new Intent(CategoryActivity.this, ShrubActivity.class);
        startActivity(intent);
    }
    public void sendMessageGrass(View view) {
        Intent intent = new Intent(CategoryActivity.this, GrassActivity.class);
        startActivity(intent);
    }
    public void sendMessageHardgoods(View view) {
        Intent intent = new Intent(CategoryActivity.this, HardgoodsActivity.class);
        startActivity(intent);
    }
    public void sendMessageLabor(View view) {
        Intent intent = new Intent(CategoryActivity.this, LaborActivity.class);
        startActivity(intent);
    }
    public void sendMessageFlowers(View view) {
        Intent intent = new Intent(CategoryActivity.this, FlowersActivity.class);
        startActivity(intent);
    }
    public void sendMessageEnd(View view) {
        Intent intent = new Intent(CategoryActivity.this, EndActivity.class);
        startActivity(intent);
    }

}
