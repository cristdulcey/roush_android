package com.example.tinder_roush.NotificationSettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;

import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

public class NotificationSettingsActivity extends AppCompatActivity {

    ImageButton backProfile;
    Switch deactivateNot;
    RadioButton newMessage, newMatch, newLike, crossPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        initObjects();
        listeners();
    }

    private void initObjects() {
        backProfile = findViewById(R.id.back_profile_notif);
        deactivateNot = findViewById(R.id.switch_deactivate_not);
        newMessage = findViewById(R.id.notification_message);
        newMatch = findViewById(R.id.notification_match);
        newLike = findViewById(R.id.notification_likes);
        crossPeople = findViewById(R.id.notification_cross);
    }

    public void listeners() {
        backProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}