package com.example.tinder_roush.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.R;
import com.example.tinder_roush.RecoveryPassword.RecoveryPasswordActivity;
import com.example.tinder_roush.Register.FragmentRegister1;
import com.example.tinder_roush.databinding.ActivityMainBinding;

public class LoginActivities extends AppCompatActivity {

    ActivityMainBinding binding;

    Button login, register, forgot_password, terms, politics;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_login);
        initObjets();
        listeners();
    }

    private void initObjets(){
        login = findViewById(R.id.button_login);
        register = findViewById(R.id.button_make_account);
        forgot_password = findViewById(R.id.button_forgot_password);
        email = findViewById(R.id.field_email);
        password = findViewById(R.id.field_password);
    }

    private void listeners(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (email.getText().toString().isEmpty()){
//                    email.setError(BaseContext.getContext().getString(R.string.message_empty_field));
//                    email.requestFocus();
//                    return;
//                }
//                if (password.getText().toString().isEmpty()){
//                    password.setError(BaseContext.getContext().getString(R.string.message_empty_field));
//                    password.requestFocus();
//                    return;
//                }
                performLoginHome();
//                data = new LoginData(phone_user_login.getText().toString(), password_login.getText().toString());
//                presenter.loginPresenter(data);
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performRecoveryPass();
            }
        });

       register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               performRegister();
            }
        });
    }

    public void performLoginHome(){
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void performRecoveryPass(){
        Intent intent = new Intent(this, RecoveryPasswordActivity.class);
        startActivity(intent);
    }

    public void performRegister(){
//      Intent intent = new Intent(this, RegisterActivity.class);
//      startActivity(intent);

        FragmentRegister1 Register1 = new FragmentRegister1();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.login_view, Register1);
        transaction.commit();

    }
}