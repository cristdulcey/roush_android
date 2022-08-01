package com.example.tinder_roush.RecoveryPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.R;

public class RecoveryPasswordActivity extends AppCompatActivity implements RecoveryPasswordInterfaces.activities{

    Button send_new_password, back_to_login;
    EditText email_recover;
    RecoveryPasswordPresenters presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);
        initObjets();
        listeners();
        presenter = new RecoveryPasswordPresenters(this);
    }

    private void initObjets(){
        back_to_login = findViewById(R.id.button_back_login);
        send_new_password = findViewById(R.id.button_send_new_password);
        email_recover = findViewById(R.id.email_recovery_password);
    }

    private void listeners() {
        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });
        send_new_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email_recover.getText().toString().isEmpty()){
                    Toast.makeText(view.getContext(), R.string.message_empty_field, Toast.LENGTH_SHORT).show();
                    email_recover.requestFocus();
                    return;
                }
                presenter.recoverPasswordPresenter(email_recover.getText().toString());
            }
        });
    }

    public void performLogin(){
        Intent intent = new Intent(this, LoginActivities.class);
        startActivity(intent);
    }
}