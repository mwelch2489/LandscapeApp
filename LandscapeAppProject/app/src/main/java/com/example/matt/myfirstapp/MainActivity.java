package com.example.matt.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, activityEnterCustomerInfo.class);
        EditText EstimiatorName = (EditText) findViewById(R.id.estimatorName);
        String message = EstimiatorName.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        if ( ( EstimiatorName.getText().toString().trim().equals(""))){
            Toast.makeText(getApplicationContext(), "Estimator Name is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(intent);
        }
    }
}
