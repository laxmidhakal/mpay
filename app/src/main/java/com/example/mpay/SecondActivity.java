package com.example.mpay;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.mpay.App.CHANNEL_1_ID;

public class SecondActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel=new NotificationChannel("MyNotification","MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        Intent axtivityIntent=new Intent(this,MainActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,
                0,axtivityIntent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyNotification")
                .setContentTitle("Hey")
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(contentIntent)
                .setContentText("Check your account");
        NotificationManagerCompat manager=NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
        //notificationManager=NotificationManagerCompat.from(this);
    }
   /* public void sendOnChannel1(View v){

        Intent axtivityIntent=new Intent(this,MainActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,
                0,axtivityIntent,0);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("NOTIFICATION")
                .setContentText("Check your account ")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .build();
        notificationManager.notify(1,notification);

    }*/
}
