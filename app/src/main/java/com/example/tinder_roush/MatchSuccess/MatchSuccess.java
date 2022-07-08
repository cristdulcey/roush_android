package com.example.tinder_roush.MatchSuccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.R;

public class MatchSuccess extends AppCompatActivity {

    Button later;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_success);
        initObjects();
        listeners();
    }

    private void initObjects() {
        later = findViewById(R.id.later_button);
    }

    private void listeners() {
        later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFromMatch();
            }
        });
    }

    public void homeFromMatch(){
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}