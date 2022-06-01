package com.example.tinder_roush.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tinder_roush.Home.HomeActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.RecoveryPassword.RecoveryPasswordActivity;

public class SuccesRegisterActivity extends AppCompatActivity {

    Button okey_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_register);
        initObjets();
        listeners();
    }

    private void initObjets(){
        okey_button = findViewById(R.id.ok_button);
    }

    private void listeners() {

        okey_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performHome();
            }
        });

    }

    public void performHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}