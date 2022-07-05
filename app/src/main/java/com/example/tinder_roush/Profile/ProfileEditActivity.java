package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

public class ProfileEditActivity extends AppCompatActivity implements ProfileInterfaces.activities2{

    ImageButton backHomeFE;
    LocalData localData;
    Button buttonLogoutFE, saveDataProfile, viewContentExclFE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        initObjects();
        listeners();
    }

    private void initObjects() {
        backHomeFE = findViewById(R.id.back_to_home_from_edit);
        localData = new LocalData();
        buttonLogoutFE = findViewById(R.id.log_out_from_edit);
        saveDataProfile = findViewById(R.id.save_profile_data);
    }

    public void listeners(){
        buttonLogoutFE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localData.LogOutApp();
                localData.deleteUserCurrent();
                Intent intent = new Intent(BaseContext.getContext(), LoginActivities.class);
                startActivity(intent);
                finish();
            }
        });

        backHomeFE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHomeFE();
            }
        });

        saveDataProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               successChangeProfile();
            }
        });

    }

    public void backToHomeFE(){
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void showData2(ProfileData data) {

    }

    @Override
    public void changeProfileData() {

    }

    public void successChangeProfile(){
        Intent intent = new Intent(BaseContext.getContext(), ProfileSuccessChange.class);
        startActivity(intent);
        finish();
    }

}