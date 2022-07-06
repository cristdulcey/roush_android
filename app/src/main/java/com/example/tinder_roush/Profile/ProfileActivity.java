package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements ProfileInterfaces.activities1{

    ImageButton backHome;
    LocalData localData;
    Button buttonLogout, editDataProfile, viewContentExcl;
    Switch activateContent;
    TextView first_name, last_name, date_birth, job, email, password, about, address;
    ProfilePresenters presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initObjects();
        listeners();
        presenter.ProfilePresenter();
    }

    private void initObjects() {
        backHome = findViewById(R.id.back_to_home);
        localData = new LocalData();
        first_name = findViewById(R.id.user_profile_name);
        last_name = findViewById(R.id.user_profile_lastname);
        job = findViewById(R.id.profile_job);
        about = findViewById(R.id.text_description_profile);
        email = findViewById(R.id.profile_email);
        password = findViewById(R.id.profile_password);
        buttonLogout = findViewById(R.id.log_out);
        activateContent = findViewById(R.id.switch_activate_content);
        editDataProfile = findViewById(R.id.edit_profile_data);
        viewContentExcl = findViewById(R.id.view_content_button);
        presenter = new ProfilePresenters(this, null);
    }

    public void listeners(){
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localData.LogOutApp();
                localData.deleteUserCurrent();
                Intent intent = new Intent(BaseContext.getContext(), LoginActivities.class);
                startActivity(intent);
                finish();
            }
        });

        editDataProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseContext.getContext(), ProfileEditActivity.class);
                startActivity(intent);
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    backToHome();
                }
            });

        activateContent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean valor;
                if(isChecked){
                    viewContentExcl.setVisibility(View.VISIBLE);
                    valor = true;
                } else {
                    viewContentExcl.setVisibility(View.INVISIBLE);
                    valor = false;
                }
            }
        });
    }

    //Methods

    public void backToHome(){
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void showData1(ProfileData data) {
        first_name.setText(data.getFirst_name());
        //last_name.append(data.getLast_name());
        date_birth.setText(data.getDate_birth());
//        date_birth.append(data.getDate_birth());
//        email.append(data.getEmail());
//        job.append(data.getJob());
//        about.append(data.getAbout());
    }
}