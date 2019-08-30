package com.example.mpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.Button;

public class DashActivity extends AppCompatActivity {
    CardView cardview;
    Button profile;
    Button history;
    Button mpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        CardView cardView=(CardView) findViewById(R.id.cardview);
        Button profile=(Button) findViewById(R.id.profile);
        Button history=(Button) findViewById(R.id.history);
    }
}
