package com.example.tinder_roush.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.example.tinder_roush.Objects.Register3Data;
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
    Button photo_preference, shop, karaoke, yoga, cook, tennis, sports, swim, art, travel, extreme, music, drink, games;
    Switch activateContent;
    String interesting, currentPhotoPath, UrlPhoto1, UrlPhoto2, UrlPhoto3, UrlPhoto4, UrlPhoto5, UrlPhoto6, IdPhoto1, IdPhoto2, IdPhoto3,IdPhoto4, IdPhoto5, IdPhoto6;
    int check_pht, check_shop,check_kar,check_yoga,check_cook,check_tennis, check_sport, check_swim, check_art,
            check_travel, check_extr, check_music,check_drink, check_game;
    ArrayList<String> orientation_list, zodiac_list;
    Spinner orientation_spinner, zodiac_spinner;
    String orientation_select, zodiac_select;
    ImageView profile_photo;
    ImageButton photo1, photo2, photo3, photo4, photo5, photo6;
    public int RESULT_PHOTO = 100;
    public final int RESULT_PHOTO_1 = 101;
    public final int RESULT_PHOTO_2 = 102;
    public final int RESULT_PHOTO_3 = 103;
    public final int RESULT_PHOTO_4 = 104;
    public final int RESULT_PHOTO_5 = 105;
    public final int RESULT_PHOTO_6 = 106;
   // int REQUEST_CODE = 200;
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
        presenter.ProfileInterestPresenter();
        presenter.ProfilePhotoUserPresenter();
        presenter.ProfilePresenterGetPhotos();
    }

    private void initObjects() {
        check_pht = 1; check_shop = 1; check_kar = 1;
        check_yoga = 1; check_cook = 1; check_tennis = 1;
        check_sport = 1; check_swim=1; check_art=1;
        check_travel = 1; check_extr = 1;
        check_music = 1; check_drink=1; check_game=1;
        orientation_spinner = findViewById(R.id.spinner_my_orientation);
        zodiac_spinner = findViewById(R.id.spinner_zodiac);
        idImage ="";
        interesting = "";
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
        photo1 = findViewById(R.id.photo_1_profile);
        photo2 = findViewById(R.id.photo_2_profile);
        photo3 = findViewById(R.id.photo_3_profile);
        photo4 = findViewById(R.id.photo_4_profile);
        photo5 = findViewById(R.id.photo_5_profile);
        photo6 = findViewById(R.id.photo_6_profile);
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
           //     presenter.changeProfilePhotosPresenter();
                RESULT_PHOTO = RESULT_PHOTO_3;
                getImageFromAlbum();
            }
        });
        photo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         //       presenter.changeProfilePhotosPresenter();
                RESULT_PHOTO = RESULT_PHOTO_4;
                getImageFromAlbum();
            }
        });
        photo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    presenter.changeProfilePhotosPresenter();
                RESULT_PHOTO = RESULT_PHOTO_5;
                getImageFromAlbum();
            }
        });
        photo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    presenter.changeProfilePhotosPresenter();
                RESULT_PHOTO = RESULT_PHOTO_6;
                getImageFromAlbum();
            }
        });

        //BUTTON INTERESTING
        photo_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String photoPreferenceText = (String) photo_preference.getText();
                if(check_pht == 1){
                    photo_preference.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = photoPreferenceText;
                    localData.register(interesting,"PREFERENCE_PHOTO");
                    check_pht = 0;
                    presenter.changeInteresting();
                }else{
                    photo_preference.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_PHOTO");
                    presenter.changeInteresting();
                    check_pht = 1;
                }
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shopPreferenceText = (String) shop.getText();
                if(check_shop == 1){
                    shop.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = shopPreferenceText;
                    localData.register(interesting,"PREFERENCE_SHOP");
                    presenter.changeInteresting();
                    check_shop = 0;
                }else{
                    shop.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_SHOP");
                    presenter.changeInteresting();
                    check_shop = 1;
                }
            }
        });
        karaoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String karaokePreferenceText = (String) karaoke.getText();
                if(check_kar == 1){
                    karaoke.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = karaokePreferenceText;
                    localData.register(interesting,"PREFERENCE_KARAOKE");
                    presenter.changeInteresting();
                    check_kar = 0;
                }else{
                    karaoke.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_KARAOKE");
                    presenter.changeInteresting();
                    check_kar = 1;
                }
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yogaPreferenceText = (String) yoga.getText();
                if(check_yoga == 1){
                    yoga.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = yogaPreferenceText;
                    localData.register(interesting,"PREFERENCE_YOGA");
                    presenter.changeInteresting();
                    check_yoga = 0;
                }else{
                    yoga.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_YOGA");
                    presenter.changeInteresting();
                    check_yoga = 1;
                }
            }
        });
        cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cookPreferenceText = (String) cook.getText();
                if(check_cook == 1){
                    cook.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = cookPreferenceText;
                    localData.register(interesting,"PREFERENCE_COOK");
                    presenter.changeInteresting();
                    check_cook = 0;
                }else{
                    cook.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_COOK");
                    presenter.changeInteresting();
                    check_cook = 1;
                }
            }
        });
        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tennisPreferenceText = (String) tennis.getText();
                if(check_tennis == 1){
                    tennis.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = tennisPreferenceText;
                    localData.register(interesting,"PREFERENCE_TENNIS");
                    presenter.changeInteresting();
                    check_tennis = 0;
                }else{
                    tennis.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_TENNIS");
                    presenter.changeInteresting();
                    check_tennis = 1;
                }
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sportPreferenceText = (String) sports.getText();
                if(check_sport == 1){
                    sports.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = sportPreferenceText;
                    localData.register(interesting,"PREFERENCE_SPORTS");
                    presenter.changeInteresting();
                    check_sport = 0;
                }else{
                    sports.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_SPORTS");
                    presenter.changeInteresting();
                    check_sport = 1;
                }
            }
        });
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String swimPreferenceText = (String) swim.getText();
                if(check_swim == 1){
                    swim.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = swimPreferenceText;
                    localData.register(interesting,"PREFERENCE_SWIM");
                    presenter.changeInteresting();
                    check_swim = 0;
                }else{
                    swim.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_SWIM");
                    presenter.changeInteresting();
                    check_swim = 1;
                }
            }
        });
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String artPreferenceText = (String) art.getText();
                if(check_art == 1){
                    art.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = artPreferenceText;
                    localData.register(interesting,"PREFERENCE_ART");
                    presenter.changeInteresting();
                    check_art = 0;
                }else{
                    art.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_ART");
                    presenter.changeInteresting();
                    check_art = 1;
                }
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String travelPreferenceText = (String) travel.getText();
                if(check_travel == 1){
                    travel.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = travelPreferenceText;
                    localData.register(interesting,"PREFERENCE_TRAVEL");
                    presenter.changeInteresting();
                    check_travel = 0;
                }else{
                    travel.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_TRAVEL");
                    presenter.changeInteresting();
                    check_travel = 1;
                }
            }
        });
        extreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String extremePreferenceText = (String) extreme.getText();
                if(check_extr == 1){
                    extreme.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = extremePreferenceText;
                    localData.register(interesting,"PREFERENCE_EXTREME");
                    presenter.changeInteresting();
                    check_extr = 0;
                }else{
                    extreme.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_EXTREME");
                    presenter.changeInteresting();
                    check_extr = 1;
                }
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String musicPreferenceText = (String) music.getText();
                if(check_music == 1){
                    music.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = musicPreferenceText;
                    localData.register(interesting,"PREFERENCE_MUSIC");
                    presenter.changeInteresting();
                    check_music = 0;
                }else{
                    music.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_MUSIC");
                    presenter.changeInteresting();
                    check_music = 1;
                }
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String drinkPreferenceText = (String) drink.getText();
                if(check_drink == 1){
                    drink.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = drinkPreferenceText;
                    localData.register(interesting,"PREFERENCE_DRINK");
                    presenter.changeInteresting();
                    check_drink = 0;
                }else{
                    drink.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_DRINK");
                    presenter.changeInteresting();
                    check_drink = 1;
                }
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gamesPreferenceText = (String) games.getText();
                if(check_game == 1){
                    games.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = gamesPreferenceText;
                    localData.register(interesting,"PREFERENCE_GAMES");
                    presenter.changeInteresting();
                    check_game = 0;
                }else{
                    games.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = gamesPreferenceText;
                    localData.register(interesting,"PREFERENCE_GAMES");
                    presenter.changeInteresting();
                    check_game = 1;
                }
            }
        });
    }

    ////
    // METHODS
    ////
    public void backToHome(){
        Intent intent = new Intent(this, MenuNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //GET PROFILE PHOTO
    @Override
    public void getPhoto(CardPersonItem data) {
        Picasso.get().load(data.getImage()).fit().centerCrop().into(profile_photo);
    }

    //GET BASIC DATA
    public  int getEdad(Date birth_date, Date current_date) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int dIni = Integer.parseInt(formatter.format(birth_date));
        int dEnd = Integer.parseInt(formatter.format(current_date));
        int age = (dEnd-dIni)/10000;
        return age;
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



    @Override
    public void showInterest(ProfileData data)  {
        String currentInterest = data.getInteresting();
        String[] interestArray = currentInterest.split(",");
        for (String s : interestArray) {
            if (s.equals("Fotografía")) { check_pht = 0;
                photo_preference.setBackgroundResource(R.drawable.border_green_round2);
            }
//            else {
//                check_pht =1;
//                photo_preference.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Compras")) { check_shop = 0;
                shop.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_shop =1;
//                shop.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Karaoke")) { check_kar = 0;
                karaoke.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_kar =1;
//                karaoke.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Yoga")) { check_yoga = 0;
                yoga.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_yoga =1;
//                yoga.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Cocina")) { check_cook = 0;
                cook.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_cook =1;
//                cook.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Tenis")) { check_tennis = 0;
                tennis.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_tennis =1;
//                tennis.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Deportes")) { check_sport = 0;
                sports.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_sport =1;
//                sports.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Natación")) { check_swim = 0;
                swim.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_swim =1;
//                swim.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Arte")) { check_art = 0;
                art.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_art =1;
//                art.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Viajar")) { check_travel = 0;
                travel.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_travel =1;
//                travel.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Extremo")) { check_extr = 0;
                extreme.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_extr =1;
//                extreme.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Música")) { check_music = 0;
                music.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_music =1;
//                music.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Bebida")) { check_drink = 0;
                drink.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_drink =1;
//                drink.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
            if (s.equals("Videojuegos")) { check_game = 0;
                games.setBackgroundResource(R.drawable.border_green_round2);}
//            else {
//                check_game =1;
//                games.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
//            }
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
        String[] projection = { MediaStore.Images.Media.DATA };
       // Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    public void showPhotos(ArrayList<CardPersonItem> person) {

        ImageButton[] photos = {photo1,photo2,photo3,photo4,photo5,photo6};
            for (int i = 0; i< person.size(); i++){
                String url = person.get(i).getImage();
                Picasso.get().load(url).fit().centerCrop().into(photos[i]);

                switch (i){
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

    //OTHER FILTERS
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