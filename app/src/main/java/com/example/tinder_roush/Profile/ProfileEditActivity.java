package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProfileEditActivity extends AppCompatActivity implements ProfileInterfaces.activities2{

    ImageButton backHomeFE;
    LocalData localData;
    Button buttonLogoutFE, saveDataProfile, viewContentExclFE;
    ProfilePresenters presenter;
    TextView ageUser;
    EditText first_name, last_name, date_birth, job, email, password, about, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        initObjects();
        listeners();
        presenter.ProfileEditPresenter();
    }

    private void initObjects() {
        backHomeFE = findViewById(R.id.back_to_home_from_edit);
        localData = new LocalData();
        first_name = findViewById(R.id.edit_user_name);
        last_name = findViewById(R.id.edit_profile_lastname);
        date_birth = findViewById(R.id.date_birth_profile);
        ageUser = findViewById(R.id.user_edit_profile_age);
        job = findViewById(R.id.edit_job);
        about = findViewById(R.id.edit_description_profile);
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_profile_password);
        buttonLogoutFE = findViewById(R.id.log_out_from_edit);
        saveDataProfile = findViewById(R.id.save_profile_data);
        presenter = new ProfilePresenters(null, this);

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
                changeProfileData();
            }
        });

    }

    public void backToHomeFE(){
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public  int getEdad(Date birth_date, Date current_date) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int dIni = Integer.parseInt(formatter.format(birth_date));
        int dEnd = Integer.parseInt(formatter.format(current_date));
        int age = (dEnd-dIni)/10000;
        return age;
    }

    @Override
    public void showData2(ProfileData data) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date birth_date = null;
        try { birth_date = dateFormat.parse(data.getDate_birth()); }
        catch (ParseException e) { e.printStackTrace(); }
        Calendar cal = Calendar.getInstance();
        Date current_date = cal.getTime();

        first_name.setText(data.getFirst_name());
        last_name.setText(data.getLast_name());
        date_birth.setText(data.getDate_birth());
        email.setText(data.getEmail());
        job.setText(data.getJob());
        about.setText(data.getAbout());
        ageUser.setText(String.valueOf(getEdad(birth_date,current_date)));
        localData.register(String.valueOf(data.getId()), "ID_USERCURRENT");
    }

    @Override
    public void changeProfileData() {
        //String id, String first_name, String last_name, String email, String date_birth, String about, String job)
        ProfileData data = new ProfileData(localData.getRegister("ID_USERCURRENT"),first_name.getText().toString(), last_name.getText().toString(), email.getText().toString(),date_birth.getText().toString(),about.getText().toString(),job.getText().toString());
        presenter.changeDataPresenter(data);
    }

    public void successChangeProfile(){
        Intent intent = new Intent(BaseContext.getContext(), ProfileSuccessChange.class);
        startActivity(intent);
    }

}