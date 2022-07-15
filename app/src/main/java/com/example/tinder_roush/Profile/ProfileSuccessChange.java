package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

public class ProfileSuccessChange extends AppCompatActivity {

    Button okProfile;
    LocalData localData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_succes_change);
        initObjects();
        listeners();
    }

    private void initObjects() {
        localData = new LocalData();
        okProfile = findViewById(R.id.ok_back_profile);
    }


    public void listeners() {
        okProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}