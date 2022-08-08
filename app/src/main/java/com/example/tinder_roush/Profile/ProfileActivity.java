package com.example.tinder_roush.Profile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.NotificationSettings.NotificationSettingsActivity;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;
import com.example.tinder_roush.Utils.SpinnerCustom;
import com.example.tinder_roush.Utils.SpinnerListener;
import com.google.android.material.slider.RangeSlider;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements ProfileInterfaces.activities1 {

    ImageButton backHome, settings;
    LocalData localData;
    Button buttonLogout, editDataProfile, viewContentExcl;
    Button manPreference, womanPreference, bothPreference, otherPreference, children_y, children_n, children_idf, pets_y, pets_n, pets_idf, smoker_y, smoker_n, smoker_idf;
    Button photo_preference, shop, karaoke, yoga, cook, tennis, sports, swim, art, travel, extreme, music, drink, games;
    Switch activateContent;
    SeekBar distance_range;
    RangeSlider age_range;
    String interesting, currentPhotoPath, UrlPhoto1, UrlPhoto2, UrlPhoto3, UrlPhoto4, UrlPhoto5, UrlPhoto6, IdPhoto1, IdPhoto2, IdPhoto3, IdPhoto4, IdPhoto5, IdPhoto6, city;
    int check_pht, check_shop, check_kar, check_yoga, check_cook, check_tennis, check_sport, check_swim, check_art, check_travel, check_extr, check_music, check_drink, check_game,
            check_man, check_woman, check_both, check_other, check_chy, check_chn, check_chidf, check_py, check_pn, check_pidf, check_smy, check_smn, check_smidf;
    ArrayList<String> orientation_list, zodiac_list;
    List<KeyPairBoolDataCustom> allCities;
    Spinner orientation_spinner, zodiac_spinner;
    SpinnerCustom spinnerCities;
    String orientation_select, zodiac_select;
    ImageView profile_photo;
    ImageButton photo1, photo2, photo3, photo4, photo5, photo6;
    String citySelected;
    public int RESULT_PHOTO = 100;
    public final int RESULT_PHOTO_1 = 101;
    public final int RESULT_PHOTO_2 = 102;
    public final int RESULT_PHOTO_3 = 103;
    public final int RESULT_PHOTO_4 = 104;
    public final int RESULT_PHOTO_5 = 105;
    public final int RESULT_PHOTO_6 = 106;
    String idImage;
    TextView first_name, last_name, date_birth, job, email, password, about, address, ageUser, distance, min_age, max_age;
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
        addSpinnerBefore();
        presenter.ProfileInterestPresenter();
        presenter.ProfilePhotoUserPresenter();
        presenter.ProfilePresenterGetPhotos();
    }

    private void initObjects() {
        check_pht = 1;
        check_shop = 1;
        check_kar = 1;
        check_yoga = 1;
        check_cook = 1;
        check_tennis = 1;
        check_sport = 1;
        check_swim = 1;
        check_art = 1;
        check_travel = 1;
        check_extr = 1;
        check_music = 1;
        check_drink = 1;
        check_game = 1;
        check_man = 1;
        check_woman = 1;
        check_both = 1;
        check_other = 1;
        check_chy = 1;
        check_chn = 1;
        check_chidf = 1;
        check_py = 1;
        check_pn = 1;
        check_pidf = 1;
        check_smy = 1;
        check_smn = 1;
        check_smidf = 1;
        distance_range = findViewById(R.id.distance_range_profile);
        age_range = findViewById(R.id.age_range_profile);
        distance_range.setMax(50);
        age_range.setValues(18f, 60f);
        distance = findViewById(R.id.max_range_profile);
        min_age = findViewById(R.id.min_age_profile);
        max_age = findViewById(R.id.max_age_profile);
        orientation_spinner = findViewById(R.id.spinner_my_orientation);
        zodiac_spinner = findViewById(R.id.spinner_zodiac);
        spinnerCities = findViewById(R.id.spinner_city_profile);
        citySelected = "";
        idImage = "";
        interesting = "";
        city = "";
        UrlPhoto1 = "";
        UrlPhoto2 = "";
        UrlPhoto3 = "";
        UrlPhoto4 = "";
        UrlPhoto5 = "";
        UrlPhoto6 = "";
        IdPhoto1 = "";
        IdPhoto2 = "";
        IdPhoto3 = "";
        IdPhoto4 = "";
        IdPhoto5 = "";
        IdPhoto6 = "";
        backHome = findViewById(R.id.back_to_home);
        settings = findViewById(R.id.config_notifications);
        localData = new LocalData();
        profile_photo = findViewById(R.id.profile_photo);
        first_name = findViewById(R.id.user_profile_name);
        last_name = findViewById(R.id.user_profile_lastname);
        date_birth = findViewById(R.id.date_birth_profile);
        ageUser = findViewById(R.id.user_profile_age);
        job = findViewById(R.id.profile_job);
        address = findViewById(R.id.profile_locations);
        about = findViewById(R.id.text_description_profile);
        email = findViewById(R.id.profile_email);
        password = findViewById(R.id.profile_password);
        buttonLogout = findViewById(R.id.log_out);
//        activateContent = findViewById(R.id.switch_activate_content);
        editDataProfile = findViewById(R.id.edit_profile_data);
//        viewContentExcl = findViewById(R.id.view_content_button);
        //filters
        orientation_list = new ArrayList<>();
        zodiac_list = new ArrayList<>();
        orientation_select = "";
        zodiac_select = "";
        manPreference = findViewById(R.id.search_man_profile);
        womanPreference = findViewById(R.id.search_woman_profile);
        bothPreference = findViewById(R.id.search_both_profile);
        otherPreference = findViewById(R.id.search_other_profile);
        children_y = findViewById(R.id.children_yes_profile);
        children_n = findViewById(R.id.children_no_profile);
        children_idf = findViewById(R.id.children_indifferent_profile);
        pets_y = findViewById(R.id.pets_yes_profile);
        pets_n = findViewById(R.id.pets_no_profile);
        pets_idf = findViewById(R.id.pets_indifferent_profile);
        smoker_y = findViewById(R.id.smoker_yes_profile);
        smoker_n = findViewById(R.id.smoker_no_profile);
        smoker_idf = findViewById(R.id.smoker_indifferent_profile);
        //Photos
        photo1 = findViewById(R.id.photo_1_profile);
        photo2 = findViewById(R.id.photo_2_profile);
        photo3 = findViewById(R.id.photo_3_profile);
        photo4 = findViewById(R.id.photo_4_profile);
        photo5 = findViewById(R.id.photo_5_profile);
        photo6 = findViewById(R.id.photo_6_profile);
        //Interesting
        photo_preference = findViewById(R.id.button_photo_preference_profile);
        shop = findViewById(R.id.button_shopping_preference_profile);
        karaoke = findViewById(R.id.button_karaoke_preference_profile);
        yoga = findViewById(R.id.button_yoga_preference_profile);
        cook = findViewById(R.id.button_cooking_preference_profile);
        tennis = findViewById(R.id.button_tennis_preference_profile);
        sports = findViewById(R.id.button_sports_preference_profile);
        swim = findViewById(R.id.button_swim_preference_profile);
        art = findViewById(R.id.button_art_preference_profile);
        travel = findViewById(R.id.button_travel_preference_profile);
        extreme = findViewById(R.id.button_extreme_preference_profile);
        music = findViewById(R.id.button_music_preference_profile);
        drink = findViewById(R.id.button_drink_preference_profile);
        games = findViewById(R.id.button_game_preference_profile);
        presenter = new ProfilePresenters(this, null);
    }

    public void listeners() {
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localData.LogOutApp();
                localData.deleteUserCurrent();
                localData.deleteInterest();
                Intent intent = new Intent(BaseContext.getContext(), LoginActivities.class);
                startActivity(intent);
                finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsProfile();
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

//        activateContent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(ProfileActivity.this, "Disponible próximamente", Toast.LENGTH_SHORT).show();
//                boolean valor;
//                if(isChecked){
//                    viewContentExcl.setVisibility(View.VISIBLE);
//                    valor = true;
//                } else {
//                    viewContentExcl.setVisibility(View.INVISIBLE);
//                    valor = false;
//                }
//            }
//        });

        orientation_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String textOrientation = "";

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                orientation_select = orientation_spinner.getSelectedItem().toString();
                for (int o = 0; o < 5; o++) {
                    if (orientation_select.equals("- - - -")) {
                        textOrientation = "";
                        break;
                    }
                    if (orientation_select.equals("Heterosexual")) {
                        textOrientation = "HETERO";
                        break;
                    }
                    if (orientation_select.equals("Gay")) {
                        textOrientation = "GAY";
                        break;
                    }
                    if (orientation_select.equals("Lesbiana")) {
                        textOrientation = "LESBIAN";
                        break;
                    }
                    if (orientation_select.equals("Bisexual")) {
                        textOrientation = "BISEXUAL";
                        break;
                    }
                    if (orientation_select.equals("Otr@")) {
                        textOrientation = "OTHER";
                        break;
                    }
                }
                localData.register(textOrientation, "SEXUAL_ORIENTATION");
                if (!textOrientation.equals("")) {
                    presenter.changePreferencesSearch();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        zodiac_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String textZodiac = "";

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                zodiac_select = zodiac_spinner.getSelectedItem().toString();
                for (int o = 0; o < 11; o++) {
                    if (zodiac_select.equals("Es indiferente")) {
                        textZodiac = "";
                        break;
                    }
                    if (zodiac_select.equals("Aries")) {
                        textZodiac = "ARIES";
                        break;
                    }
                    if (zodiac_select.equals("Tauro")) {
                        textZodiac = "TAURUS";
                        break;
                    }
                    if (zodiac_select.equals("Gémisis")) {
                        textZodiac = "GEMINI";
                        break;
                    }
                    if (zodiac_select.equals("Cáncer")) {
                        textZodiac = "CANCER";
                        break;
                    }
                    if (zodiac_select.equals("Leo")) {
                        textZodiac = "LEO";
                        break;
                    }
                    if (zodiac_select.equals("Virgo")) {
                        textZodiac = "VIRGO";
                        break;
                    }
                    if (zodiac_select.equals("Libra")) {
                        textZodiac = "LIBRA";
                        break;
                    }
                    if (zodiac_select.equals("Escorpio")) {
                        textZodiac = "SCORPIO";
                        break;
                    }
                    if (zodiac_select.equals("Sagitario")) {
                        textZodiac = "SAGITTARIUS";
                        break;
                    }
                    if (zodiac_select.equals("Capricornio")) {
                        textZodiac = "CAPRICORN";
                        break;
                    }
                    if (zodiac_select.equals("Acuario")) {
                        textZodiac = "AQUARIUS";
                        break;
                    }
                    if (zodiac_select.equals("Piscis")) {
                        textZodiac = "PISCES";
                        break;
                    }
                }
                localData.register(textZodiac, "ZODIAC_SIGN");
                if (!textZodiac.equals("")) {
                    presenter.changePreferencesSearch();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        distance_range.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance.setText(""+progress+"km" );
                if (progress!=0){
                    localData.register(String.valueOf(progress),"DISTANCE_RANGE");
                    presenter.changePreferencesSearch();
                }else {
                    localData.register(String.valueOf(1),"DISTANCE_RANGE");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        age_range.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull RangeSlider slider) {
            }

            @Override
            public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                List<Float> values = slider.getValues();
                int year = Calendar.getInstance().get(Calendar.YEAR);
                float minf = Collections.min(values);
                float maxf = Collections.max(values);
                int min = (int) minf;
                localData.register(String.valueOf(min), "MIN_AGE");
                int max = (int) maxf;
                localData.register(String.valueOf(max), "MAX_AGE");
                min_age.setText(String.valueOf(min));
                max_age.setText(String.valueOf(max));
                int date_start = year - min;
                int date_finish = year - max;
                localData.register(String.valueOf(date_start), "DATE_START");
                localData.register(String.valueOf(date_finish), "DATE_FINISH");

                presenter.changePreferencesSearch();
            }
        });


        //SEARCH
        manPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_man == 1) {
                    manPreference.setBackgroundResource(R.drawable.border_left_green);
                    manPreference.setTextColor(Color.WHITE);
                    womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    womanPreference.setTextColor(Color.GRAY);
                    bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    bothPreference.setTextColor(Color.GRAY);
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                    otherPreference.setTextColor(Color.GRAY);
                    String Text = "MAN";
                    localData.register(Text, "GENDER_PREFERENCE");
                    check_man = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_man = 1;
                }
            }
        });
        womanPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_woman == 1) {
                    womanPreference.setBackgroundResource(R.drawable.border_green);
                    womanPreference.setTextColor(Color.WHITE);
                    manPreference.setBackgroundResource(R.drawable.border_left_white);
                    manPreference.setTextColor(Color.GRAY);
                    bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    bothPreference.setTextColor(Color.GRAY);
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                    otherPreference.setTextColor(Color.GRAY);
                    String Text = "WOMAN";
                    localData.register(Text, "GENDER_PREFERENCE");
                    check_woman = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_woman = 1;
                }
            }
        });
        bothPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_both == 1) {
                    bothPreference.setBackgroundResource(R.drawable.border_green);
                    bothPreference.setTextColor(Color.WHITE);
                    manPreference.setBackgroundResource(R.drawable.border_left_white);
                    manPreference.setTextColor(Color.GRAY);
                    womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    womanPreference.setTextColor(Color.GRAY);
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                    otherPreference.setTextColor(Color.GRAY);
                    String Text = "BOTH";
                    localData.register(Text, "GENDER_PREFERENCE");
                    check_both = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_both = 1;
                }
            }
        });
        otherPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_other == 1){
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_green);
                    otherPreference.setTextColor(Color.WHITE);
                    manPreference.setBackgroundResource(R.drawable.border_left_white);
                    manPreference.setTextColor(Color.GRAY);
                    womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    womanPreference.setTextColor(Color.GRAY);
                    bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    bothPreference.setTextColor(Color.GRAY);
                    String Text = "BOTH";
                    localData.register(Text,"GENDER_PREFERENCE");
                    check_other = 0;
                    presenter.changePreferencesSearch();
                }else{
                    check_other = 1;
                }
            }
        });
        // CHILDREN
        children_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_chy == 1) {
                    children_y.setBackgroundResource(R.drawable.border_left_green);
                    children_y.setTextColor(Color.WHITE);
                    children_n.setBackgroundResource(R.drawable.border_gray_transparent);
                    children_n.setTextColor(Color.GRAY);
                    children_idf.setBackgroundResource(R.drawable.border_rigth_white);
                    children_idf.setTextColor(Color.GRAY);
                    String Text = "YES";
                    localData.register(Text, "CHILDREN_PREFERENCE");
                    check_chy = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_chy = 1;
                }
            }
        });
        children_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_chn == 1) {
                    children_n.setBackgroundResource(R.drawable.border_green);
                    children_n.setTextColor(Color.WHITE);
                    children_y.setBackgroundResource(R.drawable.border_left_white);
                    children_y.setTextColor(Color.GRAY);
                    children_idf.setBackgroundResource(R.drawable.border_rigth_white);
                    children_idf.setTextColor(Color.GRAY);
                    String Text = "NO";
                    localData.register(Text, "CHILDREN_PREFERENCE");
                    check_chn = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_chn = 1;
                }
            }
        });
        children_idf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_chidf == 1) {
                    children_idf.setBackgroundResource(R.drawable.border_rigth_green);
                    children_idf.setTextColor(Color.WHITE);
                    children_y.setBackgroundResource(R.drawable.border_left_white);
                    children_y.setTextColor(Color.GRAY);
                    children_n.setBackgroundResource(R.drawable.border_gray_transparent);
                    children_n.setTextColor(Color.GRAY);
                    String Text = "INDIFFERENT";
                    localData.register(Text, "CHILDREN_PREFERENCE");
                    check_chidf = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_chidf = 1;
                }
            }
        });
        // PETS
        pets_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_py == 1) {
                    pets_y.setBackgroundResource(R.drawable.border_left_green);
                    pets_y.setTextColor(Color.WHITE);
                    pets_n.setBackgroundResource(R.drawable.border_gray_transparent);
                    pets_n.setTextColor(Color.GRAY);
                    pets_idf.setBackgroundResource(R.drawable.border_rigth_white);
                    pets_idf.setTextColor(Color.GRAY);
                    String Text = "YES";
                    localData.register(Text, "PETS_PREFERENCE");
                    check_py = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_py = 1;
                }
            }
        });
        pets_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_pn == 1) {
                    pets_n.setBackgroundResource(R.drawable.border_green);
                    pets_n.setTextColor(Color.WHITE);
                    pets_y.setBackgroundResource(R.drawable.border_left_white);
                    pets_y.setTextColor(Color.GRAY);
                    pets_idf.setBackgroundResource(R.drawable.border_rigth_white);
                    pets_idf.setTextColor(Color.GRAY);
                    String Text = "NO";
                    localData.register(Text, "PETS_PREFERENCE");
                    check_pn = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_pn = 1;
                }
            }
        });
        pets_idf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_pidf == 1) {
                    pets_idf.setBackgroundResource(R.drawable.border_rigth_green);
                    pets_idf.setTextColor(Color.WHITE);
                    pets_y.setBackgroundResource(R.drawable.border_left_white);
                    pets_y.setTextColor(Color.GRAY);
                    pets_n.setBackgroundResource(R.drawable.border_gray_transparent);
                    pets_n.setTextColor(Color.GRAY);
                    String Text = "INDIFFERENT";
                    localData.register(Text, "PETS_PREFERENCE");
                    check_pidf = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_pidf = 1;
                }
            }
        });
        //SMOKER
        smoker_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_smy == 1) {
                    smoker_y.setBackgroundResource(R.drawable.border_left_green);
                    smoker_y.setTextColor(Color.WHITE);
                    smoker_n.setBackgroundResource(R.drawable.border_gray_transparent);
                    smoker_n.setTextColor(Color.GRAY);
                    smoker_idf.setBackgroundResource(R.drawable.border_rigth_white);
                    smoker_idf.setTextColor(Color.GRAY);
                    String Text = "YES";
                    localData.register(Text, "SMOKER_PREFERENCE");
                    check_smy = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_smy = 1;
                }
            }
        });
        smoker_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_smn == 1) {
                    smoker_n.setBackgroundResource(R.drawable.border_green);
                    smoker_n.setTextColor(Color.WHITE);
                    smoker_y.setBackgroundResource(R.drawable.border_left_white);
                    smoker_y.setTextColor(Color.GRAY);
                    smoker_idf.setBackgroundResource(R.drawable.border_rigth_white);
                    smoker_idf.setTextColor(Color.GRAY);
                    String Text = "NO";
                    localData.register(Text, "SMOKER_PREFERENCE");
                    check_smn = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_smn = 1;
                }
            }
        });
        smoker_idf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_smidf == 1) {
                    smoker_idf.setBackgroundResource(R.drawable.border_rigth_green);
                    smoker_idf.setTextColor(Color.WHITE);
                    smoker_y.setBackgroundResource(R.drawable.border_left_white);
                    smoker_y.setTextColor(Color.GRAY);
                    smoker_n.setBackgroundResource(R.drawable.border_gray_transparent);
                    smoker_n.setTextColor(Color.GRAY);
                    String Text = "INDIFFERENT";
                    localData.register(Text, "SMOKER_PREFERENCE");
                    check_smidf = 0;
                    presenter.changePreferencesSearch();
                } else {
                    check_smidf = 1;
                }
            }
        });

        //BUTTON PHOTOS
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_1;
                getImageFromAlbum();
            }
        });
        photo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_2;
                getImageFromAlbum();
            }
        });
        photo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_3;
                getImageFromAlbum();
            }
        });
        photo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_4;
                getImageFromAlbum();
            }
        });
        photo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_5;
                getImageFromAlbum();
            }
        });
        photo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_6;
                getImageFromAlbum();
            }
        });

        //BUTTON INTERESTING
        photo_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String photoPreferenceText = (String) photo_preference.getText();
                if (check_pht == 1) {
                    photo_preference.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = photoPreferenceText;
                    localData.register(interesting, "PREFERENCE_PHOTO");
                    check_pht = 0;
                    presenter.changeInteresting();
                } else {
                    photo_preference.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_PHOTO");
                    presenter.changeInteresting();
                    check_pht = 1;
                }
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shopPreferenceText = (String) shop.getText();
                if (check_shop == 1) {
                    shop.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = shopPreferenceText;
                    localData.register(interesting, "PREFERENCE_SHOP");
                    presenter.changeInteresting();
                    check_shop = 0;
                } else {
                    shop.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_SHOP");
                    presenter.changeInteresting();
                    check_shop = 1;
                }
            }
        });
        karaoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String karaokePreferenceText = (String) karaoke.getText();
                if (check_kar == 1) {
                    karaoke.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = karaokePreferenceText;
                    localData.register(interesting, "PREFERENCE_KARAOKE");
                    presenter.changeInteresting();
                    check_kar = 0;
                } else {
                    karaoke.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_KARAOKE");
                    presenter.changeInteresting();
                    check_kar = 1;
                }
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yogaPreferenceText = (String) yoga.getText();
                if (check_yoga == 1) {
                    yoga.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = yogaPreferenceText;
                    localData.register(interesting, "PREFERENCE_YOGA");
                    presenter.changeInteresting();
                    check_yoga = 0;
                } else {
                    yoga.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_YOGA");
                    presenter.changeInteresting();
                    check_yoga = 1;
                }
            }
        });
        cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cookPreferenceText = (String) cook.getText();
                if (check_cook == 1) {
                    cook.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = cookPreferenceText;
                    localData.register(interesting, "PREFERENCE_COOK");
                    presenter.changeInteresting();
                    check_cook = 0;
                } else {
                    cook.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_COOK");
                    presenter.changeInteresting();
                    check_cook = 1;
                }
            }
        });
        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tennisPreferenceText = (String) tennis.getText();
                if (check_tennis == 1) {
                    tennis.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = tennisPreferenceText;
                    localData.register(interesting, "PREFERENCE_TENNIS");
                    presenter.changeInteresting();
                    check_tennis = 0;
                } else {
                    tennis.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_TENNIS");
                    presenter.changeInteresting();
                    check_tennis = 1;
                }
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sportPreferenceText = (String) sports.getText();
                if (check_sport == 1) {
                    sports.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = sportPreferenceText;
                    localData.register(interesting, "PREFERENCE_SPORTS");
                    presenter.changeInteresting();
                    check_sport = 0;
                } else {
                    sports.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_SPORTS");
                    presenter.changeInteresting();
                    check_sport = 1;
                }
            }
        });
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String swimPreferenceText = (String) swim.getText();
                if (check_swim == 1) {
                    swim.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = swimPreferenceText;
                    localData.register(interesting, "PREFERENCE_SWIM");
                    presenter.changeInteresting();
                    check_swim = 0;
                } else {
                    swim.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_SWIM");
                    presenter.changeInteresting();
                    check_swim = 1;
                }
            }
        });
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String artPreferenceText = (String) art.getText();
                if (check_art == 1) {
                    art.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = artPreferenceText;
                    localData.register(interesting, "PREFERENCE_ART");
                    presenter.changeInteresting();
                    check_art = 0;
                } else {
                    art.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_ART");
                    presenter.changeInteresting();
                    check_art = 1;
                }
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String travelPreferenceText = (String) travel.getText();
                if (check_travel == 1) {
                    travel.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = travelPreferenceText;
                    localData.register(interesting, "PREFERENCE_TRAVEL");
                    presenter.changeInteresting();
                    check_travel = 0;
                } else {
                    travel.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_TRAVEL");
                    presenter.changeInteresting();
                    check_travel = 1;
                }
            }
        });
        extreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String extremePreferenceText = (String) extreme.getText();
                if (check_extr == 1) {
                    extreme.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = extremePreferenceText;
                    localData.register(interesting, "PREFERENCE_EXTREME");
                    presenter.changeInteresting();
                    check_extr = 0;
                } else {
                    extreme.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_EXTREME");
                    presenter.changeInteresting();
                    check_extr = 1;
                }
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String musicPreferenceText = (String) music.getText();
                if (check_music == 1) {
                    music.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = musicPreferenceText;
                    localData.register(interesting, "PREFERENCE_MUSIC");
                    presenter.changeInteresting();
                    check_music = 0;
                } else {
                    music.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_MUSIC");
                    presenter.changeInteresting();
                    check_music = 1;
                }
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String drinkPreferenceText = (String) drink.getText();
                if (check_drink == 1) {
                    drink.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = drinkPreferenceText;
                    localData.register(interesting, "PREFERENCE_DRINK");
                    presenter.changeInteresting();
                    check_drink = 0;
                } else {
                    drink.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_DRINK");
                    presenter.changeInteresting();
                    check_drink = 1;
                }
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gamesPreferenceText = (String) games.getText();
                if (check_game == 1) {
                    games.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = gamesPreferenceText;
                    localData.register(interesting, "PREFERENCE_GAMES");
                    presenter.changeInteresting();
                    check_game = 0;
                } else {
                    games.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting, "PREFERENCE_GAMES");
                    presenter.changeInteresting();
                    check_game = 1;
                }
            }
        });
    }

    ////
    // METHODS
    ////
    public void backToHome() {
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void settingsProfile() {
        Button notifications_settings, blocked_persons;
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.dialog_settings, null, false);
        notifications_settings = ll.findViewById(R.id.notifications_sett);
        blocked_persons = ll.findViewById(R.id.blocked_persons);
        AlertDialog dialog = new AlertDialog.Builder(ProfileActivity.this).setView(ll).show();
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.RIGHT | Gravity.TOP;

        dialog.getWindow().setAttributes(wmlp);

        notifications_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseContext.getContext(), NotificationSettingsActivity.class);
                startActivity(intent);
            }
        });
        blocked_persons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseContext.getContext(), NotificationSettingsActivity.class);
                startActivity(intent);
            }
        });
    }


    //GET PROFILE PHOTO
    @Override
    public void getPhoto(CardPersonItem data) {
      //  Glide.with(this).load(data.getImage()).into(profile_photo);
        Picasso.get().load(data.getImage()).fit().centerCrop().into(profile_photo); }

    //GET BASIC DATA
    public int getEdad(Date birth_date, Date current_date) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int dIni = Integer.parseInt(formatter.format(birth_date));
        int dEnd = Integer.parseInt(formatter.format(current_date));
        int age = (dEnd - dIni) / 10000;
        return age;
    }

    @Override
    public void showData1(ProfileData data) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date birth_date = null;
        try {
            birth_date = dateFormat.parse(data.getDate_birth());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        Date current_date = cal.getTime();

        first_name.setText(data.getFirst_name());
        last_name.setText(data.getLast_name());
        date_birth.setText(data.getDate_birth());
        email.setText(data.getEmail());
        job.setText(data.getJob());
        about.setText(data.getAbout());
        address.setText(data.getAddress());
        ageUser.setText(String.valueOf(getEdad(birth_date, current_date)));
        localData.register(String.valueOf(data.getId()), "ID_USERCURRENT");
        distance.setText(String.valueOf(data.getDistance())+"km");
       // distance_range.setProgress(Integer.parseInt(data.getDistance()));
        distance_range.setProgress(Integer.parseInt(localData.getRegister("DISTANCE_RANGE")));
        city = data.getCity();
        if (localData.getRegister("MIN_AGE").equals("")){
            String min_a= "18";
            localData.register(min_a,"MIN_AGE"); }
        if (localData.getRegister("MAX_AGE").equals("")){
            String max_a= "60";
            localData.register(max_a,"MAX_AGE"); }

        min_age.setText(localData.getRegister("MIN_AGE"));
        max_age.setText(localData.getRegister("MAX_AGE"));
        List<Float> values = new ArrayList<Float>();
        values.add(new Float(localData.getRegister("MIN_AGE")));
        values.add(new Float(localData.getRegister("MAX_AGE")));
        age_range.setValues(values);
//        //SEARCH
        for (int i = 0; i < 4; i++) {
            if (data.getSearch().equals("MAN")) {
                manPreference.setBackgroundResource(R.drawable.border_left_green);
                manPreference.setTextColor(Color.WHITE);
                localData.register("MAN", "GENDER_PREFERENCE");
                break;
            } else {
                manPreference.setBackgroundResource(R.drawable.border_left_white);
                manPreference.setTextColor(Color.GRAY);
                //localData.register("","GENDER_PREFERENCE");
            }
            if (data.getSearch().equals("WOMAN")) {
                womanPreference.setBackgroundResource(R.drawable.border_green);
                womanPreference.setTextColor(Color.WHITE);
                localData.register("WOMAN", "GENDER_PREFERENCE");
                break;
            } else {
                womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                womanPreference.setTextColor(Color.GRAY);
                //   localData.register("","GENDER_PREFERENCE");
            }
            if (data.getSearch().equals("BOTH")) {
                bothPreference.setBackgroundResource(R.drawable.border_green);
                bothPreference.setTextColor(Color.WHITE);
                localData.register("BOTH", "GENDER_PREFERENCE");
                break;
            } else {
                bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                bothPreference.setTextColor(Color.GRAY);
                // localData.register("","GENDER_PREFERENCE");
            }
            if (data.getSearch().equals("OTHER")) {
                otherPreference.setBackgroundResource(R.drawable.border_rigth_green);
                otherPreference.setTextColor(Color.WHITE);
                localData.register("OTHER", "GENDER_PREFERENCE");
                break;
            } else {
                otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                otherPreference.setTextColor(Color.GRAY);
                // localData.register("","GENDER_PREFERENCE");
            }
        }
        //CHILDREN
        for (int i = 0; i < 3; i++) {
            if (data.getWith_children().equals("YES")) {
                children_y.setBackgroundResource(R.drawable.border_left_green);
                children_y.setTextColor(Color.WHITE);
                localData.register("YES", "CHILDREN_PREFERENCE");
                break;
            } else {
                children_y.setBackgroundResource(R.drawable.border_left_white);
                children_y.setTextColor(Color.GRAY);
            }
            if (data.getWith_children().equals("NO")) {
                children_n.setBackgroundResource(R.drawable.border_green);
                children_n.setTextColor(Color.WHITE);
                localData.register("NO", "CHILDREN_PREFERENCE");
                break;
            } else {
                children_n.setBackgroundResource(R.drawable.border_gray_transparent);
                children_n.setTextColor(Color.GRAY);
            }
            if (data.getWith_children().equals("INDIFFERENT")) {
                children_idf.setBackgroundResource(R.drawable.border_rigth_green);
                children_idf.setTextColor(Color.WHITE);
                localData.register("INDIFFERENT", "CHILDREN_PREFERENCE");
                break;
            } else {
                children_idf.setBackgroundResource(R.drawable.border_rigth_white);
                children_idf.setTextColor(Color.GRAY);
            }
        }
        //PETS
        for (int i = 0; i < 3; i++) {
            if (data.getWith_pets().equals("YES")) {
                pets_y.setBackgroundResource(R.drawable.border_left_green);
                pets_y.setTextColor(Color.WHITE);
                localData.register("YES", "PETS_PREFERENCE");
                break;
            } else {
                pets_y.setBackgroundResource(R.drawable.border_left_white);
                pets_y.setTextColor(Color.GRAY);
            }
            if (data.getWith_pets().equals("NO")) {
                pets_n.setBackgroundResource(R.drawable.border_green);
                pets_n.setTextColor(Color.WHITE);
                localData.register("NO", "PETS_PREFERENCE");
                break;
            } else {
                pets_n.setBackgroundResource(R.drawable.border_gray_transparent);
                pets_n.setTextColor(Color.GRAY);
            }
            if (data.getWith_pets().equals("INDIFFERENT")) {
                pets_idf.setBackgroundResource(R.drawable.border_rigth_green);
                pets_idf.setTextColor(Color.WHITE);
                localData.register("INDIFFERENT", "PETS_PREFERENCE");
                break;
            } else {
                pets_idf.setBackgroundResource(R.drawable.border_rigth_white);
                pets_idf.setTextColor(Color.GRAY);
            }
        }
        //SMOKER
        for (int i = 0; i < 3; i++) {
            if (data.getSmoker().equals("YES")) {
                smoker_y.setBackgroundResource(R.drawable.border_left_green);
                smoker_y.setTextColor(Color.WHITE);
                localData.register("YES", "SMOKER_PREFERENCE");
                break;
            } else {
                smoker_y.setBackgroundResource(R.drawable.border_left_white);
                smoker_y.setTextColor(Color.GRAY);
            }
            if (data.getSmoker().equals("NO")) {
                smoker_n.setBackgroundResource(R.drawable.border_green);
                smoker_n.setTextColor(Color.WHITE);
                localData.register("NO", "SMOKER_PREFERENCE");
                break;
            } else {
                smoker_n.setBackgroundResource(R.drawable.border_gray_transparent);
                smoker_n.setTextColor(Color.GRAY);
            }
            if (data.getSmoker().equals("INDIFFERENT")) {
                smoker_idf.setBackgroundResource(R.drawable.border_rigth_green);
                smoker_idf.setTextColor(Color.WHITE);
                localData.register("INDIFFERENT", "SMOKER_PREFERENCE");
                break;
            } else {
                smoker_idf.setBackgroundResource(R.drawable.border_rigth_white);
                smoker_idf.setTextColor(Color.GRAY);
            }
        }

        ArrayList<String> orientation = new ArrayList<>();
        orientation.add(0, "");
        orientation.add("HETERO");
        orientation.add("GAY");
        orientation.add("LESBIAN");
        orientation.add("BISEXUAL");
        orientation.add("OTHER");
        int posOrientation = 0;
        for (int i = 0; i < orientation.size(); i++) {
            if (orientation.get(i).equals(data.getSexual_orientation()) && !orientation.get(i).equals("- - - -")) {
                posOrientation = i;
                break;
            }
        }
        orientation_spinner.setSelection(posOrientation);

        ArrayList<String> zodiac = new ArrayList<>();
        zodiac.add(0, "");
        zodiac.add("ARIES");
        zodiac.add("TAURUS");
        zodiac.add("GEMINI");
        zodiac.add("CANCER");
        zodiac.add("LEO");
        zodiac.add("VIRGO");
        zodiac.add("LIBRA");
        zodiac.add("SCORPIO");
        zodiac.add("SAGITTARIUS");
        zodiac.add("CAPRICORN");
        zodiac.add("AQUARIUS");
        zodiac.add("PISCES");
        int posZodiac = 0;
        for (int i = 0; i < zodiac.size(); i++) {
            if (zodiac.get(i).equals(data.getZodiac_sign()) && !zodiac.get(i).equals("Es indiferente")) {
                posZodiac = i;
                break;
            }
        }
        zodiac_spinner.setSelection(posZodiac);
        citySelected = data.getCity();
        presenter.citiesPresenter();
//        int posCities = 0;
//        for (int i = 0; i < allCities.size(); i++) {
//            if (allCities.get(i).getId().equals(data.getCity())) {
//                posCities = i;
//                break; }
//        }spinnerCities.setSelection(posCities);
    }

    @Override
    public void showInterest(ProfileData data) {
        String currentInterest = data.getInteresting();
        String[] interestArray = currentInterest.split(",");
        for (String s : interestArray) {
            if (s.equals("Fotografía")) {
                check_pht = 0;
                photo_preference.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Compras")) {
                check_shop = 0;
                shop.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Karaoke")) {
                check_kar = 0;
                karaoke.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Yoga")) {
                check_yoga = 0;
                yoga.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Cocina")) {
                check_cook = 0;
                cook.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Tenis")) {
                check_tennis = 0;
                tennis.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Deportes")) {
                check_sport = 0;
                sports.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Natación")) {
                check_swim = 0;
                swim.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Arte")) {
                check_art = 0;
                art.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Viajar")) {
                check_travel = 0;
                travel.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Extremo")) {
                check_extr = 0;
                extreme.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Música")) {
                check_music = 0;
                music.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Bebida")) {
                check_drink = 0;
                drink.setBackgroundResource(R.drawable.border_green_round2);
            }
            if (s.equals("Videojuegos")) {
                check_game = 0;
                games.setBackgroundResource(R.drawable.border_green_round2);
            }
        }
    }

    //GET IMAGES AND UPDATE
    private void getImageFromAlbum() {
        try {
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_PHOTO);
        } catch (Exception exp) {
            Log.i("Error", exp.toString());
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_PHOTO_1 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            photo1.setImageBitmap(bitmap);
            UrlPhoto1 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image");
            Log.e("PATH PICKED IMAGE_1", currentPhotoPath);
            presenter.changeProfilePhotosPresenter(IdPhoto1);
        }
        if (requestCode == RESULT_PHOTO_2 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            photo2.setImageBitmap(bitmap);
            UrlPhoto2 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image");
            Log.e("PATH PICKED IMAGE_2", currentPhotoPath);
            presenter.changeProfilePhotosPresenter(IdPhoto2);
        }
        if (requestCode == RESULT_PHOTO_3 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            photo3.setImageBitmap(bitmap);
            UrlPhoto3 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image");
            Log.e("PATH PICKED IMAGE_3", currentPhotoPath);
            presenter.changeProfilePhotosPresenter(IdPhoto3);
        }
        if (requestCode == RESULT_PHOTO_4 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            photo4.setImageBitmap(bitmap);
            UrlPhoto4 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image");
            presenter.changeProfilePhotosPresenter(IdPhoto4);
            Log.e("PATH PICKED IMAGE_4", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_5 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            photo5.setImageBitmap(bitmap);
            UrlPhoto5 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image");
            presenter.changeProfilePhotosPresenter(IdPhoto5);
            Log.e("PATH PICKED IMAGE_5", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_6 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            photo6.setImageBitmap(bitmap);
            UrlPhoto6 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image");
            presenter.changeProfilePhotosPresenter(IdPhoto6);
            Log.e("PATH PICKED IMAGE_6", currentPhotoPath);
        }
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        // Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    public void showPhotos(ArrayList<CardPersonItem> person) {

        ImageButton[] photos = {photo1, photo2, photo3, photo4, photo5, photo6};
        for (int i = 0; i < person.size(); i++) {
            String url = person.get(i).getImage();
            Picasso.get().load(url).fit().centerCrop().into(photos[i]);

            switch (i) {
                case 0:
                    IdPhoto1 = person.get(i).getId();
                    break;
                case 1:
                    IdPhoto2 = person.get(i).getId();
                    break;
                case 2:
                    IdPhoto3 = person.get(i).getId();
                    break;
                case 3:
                    IdPhoto4 = person.get(i).getId();
                    break;
                case 4:
                    IdPhoto5 = person.get(i).getId();
                    break;
                case 5:
                    IdPhoto6 = person.get(i).getId();
                    break;
            }
        }
    }

    //SPINNERS
    public void orientationList() {
        orientation_list.add(0, "- - - -");
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
        zodiac_list.add(0, "Es indiferente");
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

    public void addSpinnerBefore() {
        List<KeyPairBoolDataCustom> listArray1 = new ArrayList<>();
        KeyPairBoolDataCustom h = new KeyPairBoolDataCustom();
        h.setId("0");
        h.setExtra("--");
        h.setName("cargando");
        h.setSelected(false);
        listArray1.add(h);
        addItemsSpinnerCity(listArray1);
    }

    //Spinner Ciudades
    public void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities) {

        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getId().equals(citySelected)) {
                cities.get(i).setSelected(true);
                break;
            }
        }
        allCities = cities;
        spinnerCities.setSearchEnabled(true);
        spinnerCities.setSearchHint("");
        spinnerCities.setItems(cities, new SpinnerListener() {
            @Override
            public void onItemsSelected(KeyPairBoolDataCustom selectedItem) {
                city = selectedItem.getId();
            }

            @Override
            public void onClear() {
            }
        });
    }
}