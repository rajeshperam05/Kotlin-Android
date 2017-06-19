package com.swayam.kotlintestapp.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.swayam.kotlintestapp.R;

public class NotificationActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etDesc = (EditText) findViewById(R.id.etDesc);
    }

    public void send(View view) {

        String title = etTitle.getText().toString();
        String desc = etDesc.getText().toString();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
        builder.setContentTitle(title);
        builder.setContentText(desc);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Intent intent = new Intent(NotificationActivity.this, HomeActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(NotificationActivity.this);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        manager.notify(0, builder.build());

    }
}
