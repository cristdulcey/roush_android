package com.example.tinder_roush.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.Register4Data;
import com.example.tinder_roush.R;
import com.example.tinder_roush.RecoveryPassword.RecoveryPasswordActivity;
import com.example.tinder_roush.Utils.BaseContext;

public class FragmentRegister4 extends Fragment implements RegisterInterfaces.fragment4{

    Button photo_preference, create_account, shop, karaoke, yoga, cook, tennis, sports, swim, art, travel, extreme, music, drink, games;
    LocalData localData;
    String interesting;
    RegisterPresenters presenter;
    Register4Data register4Data;
    Context context;
    public FragmentRegister4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_4, container, false);

        context = view.getContext();
        initObjets(view);
        listeners();
        return view;
    }

    public void initObjets(View view){
        interesting = "";
        create_account = view.findViewById(R.id.create_account_final);
        photo_preference = view.findViewById(R.id.button_photo_preference);
        shop = view.findViewById(R.id.button_shop_preference);
        karaoke = view.findViewById(R.id.button_karaoke_preference);
        yoga = view.findViewById(R.id.button_yoga_preference);
        cook = view.findViewById(R.id.button_cooking_preference);
        tennis = view.findViewById(R.id.button_tennis_preference);
        sports = view.findViewById(R.id.button_sports_preference);
        swim = view.findViewById(R.id.button_swim_preference);
        art = view.findViewById(R.id.button_art_preference);
        travel = view.findViewById(R.id.button_travel_preference);
        extreme = view.findViewById(R.id.button_extreme_preference);
        music = view.findViewById(R.id.button_music_preference);
        drink = view.findViewById(R.id.button_drink_preference);
        games = view.findViewById(R.id.button_game_preference);
        localData = new LocalData();
        presenter=new RegisterPresenters(null, null, null, this);
    }

    public void listeners(){
        photo_preference.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String photoPreferenceText = (String) photo_preference.getText();
                if(check == 1){
                    photo_preference.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = photoPreferenceText;
                    localData.register(interesting,"PREFERENCE_PHOTO");
                    check = 0;
                }else{
                    photo_preference.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_PHOTO");
                    check = 1;
                }
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String shopPreferenceText = (String) shop.getText();
                if(check == 1){
                    shop.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = shopPreferenceText;
                    localData.register(interesting,"PREFERENCE_SHOP");
                    check = 0;
                }else{
                    shop.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_SHOP");
                    check = 1;
                }
            }
        });
        karaoke.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String karaokePreferenceText = (String) karaoke.getText();
                if(check == 1){
                    karaoke.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = karaokePreferenceText;
                    localData.register(interesting,"PREFERENCE_KARAOKE");
                    check = 0;
                }else{
                    karaoke.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_KARAOKE");
                    check = 1;
                }
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String yogaPreferenceText = (String) yoga.getText();
                if(check == 1){
                    yoga.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = yogaPreferenceText;
                    localData.register(interesting,"PREFERENCE_YOGA");
                    check = 0;
                }else{
                    yoga.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_YOGA");
                    check = 1;
                }
            }
        });
        cook.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String cookPreferenceText = (String) cook.getText();
                if(check == 1){
                    cook.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = cookPreferenceText;
                    localData.register(interesting,"PREFERENCE_COOK");
                    check = 0;
                }else{
                    cook.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_COOK");
                    check = 1;
                }
            }
        });
        tennis.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String tennisPreferenceText = (String) tennis.getText();
                if(check == 1){
                    tennis.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = tennisPreferenceText;
                    localData.register(interesting,"PREFERENCE_TENNIS");
                    check = 0;
                }else{
                    tennis.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_TENNIS");
                    check = 1;
                }
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String sportPreferenceText = (String) sports.getText();
                if(check == 1){
                    sports.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = sportPreferenceText;
                    localData.register(interesting,"PREFERENCE_SPORTS");
                    check = 0;
                }else{
                    sports.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_SPORTS");
                    check = 1;
                }
            }
        });
        swim.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String swimPreferenceText = (String) swim.getText();
                if(check == 1){
                    swim.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = swimPreferenceText;
                    localData.register(interesting,"PREFERENCE_SWIM");
                    check = 0;
                }else{
                    swim.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_SWIM");
                    check = 1;
                }
            }
        });
        art.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String artPreferenceText = (String) art.getText();
                if(check == 1){
                    art.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = artPreferenceText;
                    localData.register(interesting,"PREFERENCE_ART");
                    check = 0;
                }else{
                    art.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_ART");
                    check = 1;
                }
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String travelPreferenceText = (String) travel.getText();
                if(check == 1){
                    travel.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = travelPreferenceText;
                    localData.register(interesting,"PREFERENCE_TRAVEL");
                    check = 0;
                }else{
                    travel.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_TRAVEL");
                    check = 1;
                }
            }
        });
        extreme.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String extremePreferenceText = (String) extreme.getText();
                if(check == 1){
                    extreme.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = extremePreferenceText;
                    localData.register(interesting,"PREFERENCE_EXTREME");
                    check = 0;
                }else{
                    extreme.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_EXTREME");
                    check = 1;
                }
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String musicPreferenceText = (String) music.getText();
                if(check == 1){
                    music.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = musicPreferenceText;
                    localData.register(interesting,"PREFERENCE_MUSIC");
                    check = 0;
                }else{
                    music.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_MUSIC");
                    check = 1;
                }
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String drinkPreferenceText = (String) drink.getText();
                if(check == 1){
                    drink.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = drinkPreferenceText;
                    localData.register(interesting,"PREFERENCE_DRINK");
                    check = 0;
                }else{
                    drink.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = "";
                    localData.register(interesting,"PREFERENCE_DRINK");
                    check = 1;
                }
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                String gamesPreferenceText = (String) games.getText();
                if(check == 1){
                    games.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = gamesPreferenceText;
                    localData.register(interesting,"PREFERENCE_GAMES");
                    check = 0;
                }else{
                    games.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    interesting = gamesPreferenceText;
                    localData.register(interesting,"PREFERENCE_GAMES");
                    check = 1;
                }
            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interesting == "") {
                    Toast.makeText(BaseContext.getContext(), "Elige un interés", Toast.LENGTH_SHORT).show();
                } else {
                    register4();
                }
            }
        });
    }

    @Override
    public void register4() {
        register4Data = new Register4Data(interesting);
        presenter.register4Presenters(register4Data);
    }

    public void performSuccessRegister(){
        Intent intent = new Intent(context, SuccesRegisterActivity.class);
        startActivity(intent);
    }

}