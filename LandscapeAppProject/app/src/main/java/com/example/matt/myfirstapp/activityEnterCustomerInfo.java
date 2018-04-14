package com.example.matt.myfirstapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class activityEnterCustomerInfo extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_customer_info);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message + "'s");
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(activityEnterCustomerInfo.this, CategoryActivity.class);

        EditText CustomerName = (EditText) findViewById(R.id.CustomerName);
        EditText Address = (EditText) findViewById(R.id.Address);
        EditText PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        EditText Email = (EditText) findViewById(R.id.Email);

        if ( ( CustomerName.getText().toString().trim().equals(""))){
            Toast.makeText(getApplicationContext(), "User name is empty", Toast.LENGTH_SHORT).show();
        }
        if(( Address.getText().toString().trim().equals(""))){
            Toast.makeText(getApplicationContext(), "Address is empty", Toast.LENGTH_SHORT).show();
        }
        if(( PhoneNumber.getText().toString().trim().equals("")) ){
            Toast.makeText(getApplicationContext(), "Phone Number is empty", Toast.LENGTH_SHORT).show();
        }
        if(( Email.getText().toString().trim().equals(""))){
            Toast.makeText(getApplicationContext(), "Email is empty", Toast.LENGTH_SHORT).show();
        }
        else
            startActivity(intent);
        }
}
