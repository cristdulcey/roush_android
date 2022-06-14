package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ImageButton backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initObjects();
        listeners();
    }

    private void initObjects() {
        backHome = findViewById(R.id.back_to_home);
    }

    public void listeners(){
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    backToHome();
                }
            });
        }

        public void backToHome(){
            Intent intent = new Intent(this, MenuNavigation.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
}