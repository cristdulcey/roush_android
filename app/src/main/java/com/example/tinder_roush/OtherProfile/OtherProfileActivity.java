package com.example.tinder_roush.OtherProfile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OtherProfileActivity extends AppCompatActivity implements OtherProfileInterfaces.activities{

    LocalData localData;
    OtherProfilePresenters presenter;
    ImageView profile_photo, photo1, photo2;
    TextView other_name, other_lastname, other_job, other_description, other_adress, other_age, other_ide_gender, other_orientation,
            interest1, interest2, interest3, interest4, interest5, is_smoker, had_kids, had_pets, zodiac_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_profile);
        initObjects();
        presenter.getOtherInformation();
        listeners();
    }

    private void initObjects() {
        presenter = new OtherProfilePresenters(this);
        localData = new LocalData();
        profile_photo = findViewById(R.id.other_profile_photo);
        photo1 = findViewById(R.id.other_profile_photo1);
        photo2 = findViewById(R.id.other_profile_photo2);
        other_description = findViewById(R.id.other_profile_description);
        other_name = findViewById(R.id.other_profile_name);
        other_lastname = findViewById(R.id.other_profile_lastname);
        other_job = findViewById(R.id.other_profile_job);
        other_adress = findViewById(R.id.other_profile_locations);
        other_age = findViewById(R.id.other_profile_age);
        other_ide_gender = findViewById(R.id.other_profile_id_gender);
        other_orientation = findViewById(R.id.other_profile_orientation);
        is_smoker = findViewById(R.id.other_smoker);
        had_kids = findViewById(R.id.other_kids);
        had_pets = findViewById(R.id.other_pets);
        zodiac_pref = findViewById(R.id.other_zodiac_pref);
    }

    private void listeners() {
    }

    public int getEdad(Date birth_date, Date current_date) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int dIni = Integer.parseInt(formatter.format(birth_date));
        int dEnd = Integer.parseInt(formatter.format(current_date));
        int age = (dEnd - dIni) / 10000;
        return age;
    }

    @Override
    public void showOtherData(ArrayList<CardPersonItem> data) {
        for (int i=0; i<data.size(); i++){
            if (i==0){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date birth_date = null;
                Calendar cal = Calendar.getInstance();
                Date current_date = cal.getTime();
                try {
                    birth_date = dateFormat.parse(data.get(i).getPerson().getDate_birth());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                other_age.setText(String.valueOf(getEdad(birth_date,current_date)));
                other_name.setText(data.get(i).getPerson().getFirst_name());
                other_lastname.setText(data.get(i).getPerson().getLast_name());
                other_orientation.setText(data.get(i).getPerson().getSexual_orientation());
                other_job.setText(data.get(i).getPerson().getJob());
                other_ide_gender.setText(data.get(i).getPerson().getGender());
                is_smoker.setText(data.get(i).getPerson().getSmoker());
                had_kids.setText(data.get(i).getPerson().getWith_children());
                had_pets.setText(data.get(i).getPerson().getWith_pets());
                other_adress.setText(data.get(i).getPerson().getAddress());
                other_description.setText(data.get(i).getPerson().getAbout());
                Picasso.get().load(data.get(i).getImage()).fit().centerCrop().into(profile_photo);
            }else {
                if (i==1 && !data.get(i).getImage().isEmpty()){
                    Picasso.get().load(data.get(i).getImage()).fit().centerCrop().into(photo1);
                }else{
                    photo1.setVisibility(View.GONE);
                }
                if (i==2 && !data.get(i).getImage().isEmpty()){
                    Picasso.get().load(data.get(i).getImage()).fit().centerCrop().into(photo2);
                }else{
                    photo2.setVisibility(View.GONE);
                }
            }
        }
    }
}