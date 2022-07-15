package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements ProfileInterfaces.activities1{

    ImageButton backHome;
    LocalData localData;
    Button buttonLogout, editDataProfile, viewContentExcl;
    Switch activateContent;
    ArrayList<String> orientation_list, zodiac_list;
    Spinner orientation_spinner, zodiac_spinner;
    String orientation_select, zodiac_select;
    ImageView profile_photo;
    String idImage;
    TextView first_name, last_name, date_birth, job, email, password, about, address, ageUser;
    ProfilePresenters presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initObjects();
        listeners();
        orientationList();
        zodiacList();
        presenter.ProfilePresenter();
        presenter.ProfilePhotoUserPresenter();
    }

    private void initObjects() {
        orientation_spinner = findViewById(R.id.spinner_my_orientation);
        zodiac_spinner = findViewById(R.id.spinner_zodiac);
        idImage ="";
        backHome = findViewById(R.id.back_to_home);
        localData = new LocalData();
        profile_photo = findViewById(R.id.profile_photo);
        first_name = findViewById(R.id.user_profile_name);
        last_name = findViewById(R.id.user_profile_lastname);
        date_birth = findViewById(R.id.date_birth_profile);
        ageUser = findViewById(R.id.user_profile_age);
        job = findViewById(R.id.profile_job);
        about = findViewById(R.id.text_description_profile);
        email = findViewById(R.id.profile_email);
        password = findViewById(R.id.profile_password);
        buttonLogout = findViewById(R.id.log_out);
        activateContent = findViewById(R.id.switch_activate_content);
        editDataProfile = findViewById(R.id.edit_profile_data);
        viewContentExcl = findViewById(R.id.view_content_button);
        orientation_list = new ArrayList<>();
        zodiac_list = new ArrayList<>();
        orientation_select = "";
        zodiac_select = "";
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
            public void onClick(View view) { backToHome(); }
            });

        activateContent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ProfileActivity.this, "Disponible próximamente", Toast.LENGTH_SHORT).show();
//                boolean valor;
//                if(isChecked){
//                    viewContentExcl.setVisibility(View.VISIBLE);
//                    valor = true;
//                } else {
//                    viewContentExcl.setVisibility(View.INVISIBLE);
//                    valor = false;
//                }
            }
        });

        orientation_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                orientation_select = orientation_spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        zodiac_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                zodiac_select = zodiac_spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
    }

    //Methods

    public void backToHome(){
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
    public void getPhoto(CardPersonItem data) {
        Picasso.get().load(data.getImage()).fit().centerCrop().into(profile_photo);
    }

    @Override
    public void showData1(ProfileData data) {

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

    public void orientationList(){
        orientation_list.add("Heterosexual");
        orientation_list.add("Gay");
        orientation_list.add("Lesbiana");
        orientation_list.add("Bisexual");
        orientation_list.add("Otr@");
        ArrayAdapter<String> orientationArrayAdapter = new ArrayAdapter<>(BaseContext.getContext(), R.layout.spinner_custom_textview_orientation, orientation_list);
        orientationArrayAdapter.setDropDownViewResource(R.layout.spinner_custom_textview_orientation);
        orientation_spinner.setAdapter(orientationArrayAdapter);
    }

    private void zodiacList() {
        zodiac_list.add(0,"Es indiferente");
        zodiac_list.add("Aries");
        zodiac_list.add("Tauro");
        zodiac_list.add("Géminis");
        zodiac_list.add("Cáncer");
        zodiac_list.add("Leo");
        zodiac_list.add("Virgo");
        zodiac_list.add("Libra");
        zodiac_list.add("Escorpio");
        zodiac_list.add("Sagitario");
        zodiac_list.add("Capricornio");
        zodiac_list.add("Acuario");
        zodiac_list.add("Piscis");
        ArrayAdapter<String> zodiacArrayAdapter = new ArrayAdapter<>(BaseContext.getContext(), R.layout.spinner_custom_textview_orientation, zodiac_list);
        zodiacArrayAdapter.setDropDownViewResource(R.layout.spinner_custom_textview_orientation);
        zodiac_spinner.setAdapter(zodiacArrayAdapter);
    }
}