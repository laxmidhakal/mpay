package com.example.mpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PayingActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paying);
        EditText et1=(EditText) findViewById(R.id.et1);
        EditText et2=(EditText) findViewById(R.id.et2);
        
    }
}
