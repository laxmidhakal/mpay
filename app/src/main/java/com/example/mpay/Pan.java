package com.example.mpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
