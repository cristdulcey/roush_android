package com.example.tinder_roush.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.Register4Data;
import com.example.tinder_roush.R;
import com.example.tinder_roush.RecoveryPassword.RecoveryPasswordActivity;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                if(check == 1){
                    photo_preference.setBackgroundResource(R.drawable.border_green_round2);
                    String photoPreferenceText = (String) photo_preference.getText();
                    localData.register(photoPreferenceText,"PREFERENCE_PHOTO");
                    interesting = localData.getRegister("PREFERENCE_PHOTO");
                    localData.register(interesting,"PREFERENCE");
                    check = 0;
                }else{
                    photo_preference.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    shop.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = (String) shop.getText();
                    String shopPreferenceText = (String) shop.getText();
                    localData.register(shopPreferenceText,"PREFERENCE_SHOP");
                    interesting = localData.getRegister("PREFERENCE_SHOP");
                    localData.register(interesting,"PREFERENCE");
                    check = 0;
                }else{
                    shop.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        karaoke.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    karaoke.setBackgroundResource(R.drawable.border_green_round2);
                    String karaokePreferenceText = (String) karaoke.getText();
                    localData.register(karaokePreferenceText,"PREFERENCE_KARAOKE");
                    interesting = localData.getRegister("PREFERENCE_KARAOKE");
                    localData.register(interesting,"PREFERENCE");
                    check = 0;
                }else{
                    karaoke.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    yoga.setBackgroundResource(R.drawable.border_green_round2);
                    interesting = (String) yoga.getText();
                    String yogaPreferenceText = (String) yoga.getText();
                    localData.register(yogaPreferenceText,"PREFERENCE_YOGA");
                    interesting = localData.getRegister("PREFERENCE_YOGA");
                    localData.register(interesting,"PREFERENCE");
                    check = 0;
                }else{
                    yoga.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        cook.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    cook.setBackgroundResource(R.drawable.border_green_round2);
                    String cookPreferenceText = (String) cook.getText();
                    localData.register(cookPreferenceText,"PREFERENCE_COOK");
                    interesting = localData.getRegister("PREFERENCE_COOK");
                    localData.register(interesting,"PREFERENCE");
                    check = 0;
                }else{
                    cook.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        tennis.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    tennis.setBackgroundResource(R.drawable.border_green_round2);
                    String tennisPreferenceText = (String) tennis.getText();
                    localData.register(tennisPreferenceText,"PREFERENCE_TENNIS");
                    check = 0;
                }else{
                    tennis.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    sports.setBackgroundResource(R.drawable.border_green_round2);
                    String sportPreferenceText = (String) sports.getText();
                    localData.register(sportPreferenceText,"PREFERENCE_SPORTS");
                    check = 0;
                }else{
                    sports.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        swim.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    swim.setBackgroundResource(R.drawable.border_green_round2);
                    String swimPreferenceText = (String) swim.getText();
                    localData.register(swimPreferenceText,"PREFERENCE_SWIM");
                    check = 0;
                }else{
                    swim.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        art.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    art.setBackgroundResource(R.drawable.border_green_round2);
                    String artPreferenceText = (String) art.getText();
                    localData.register(artPreferenceText,"PREFERENCE_ART");
                    check = 0;
                }else{
                    art.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    travel.setBackgroundResource(R.drawable.border_green_round2);
                    String travelPreferenceText = (String) travel.getText();
                    localData.register(travelPreferenceText,"PREFERENCE_TRAVEL");
                    check = 0;
                }else{
                    travel.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        extreme.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    extreme.setBackgroundResource(R.drawable.border_green_round2);
                    String extremePreferenceText = (String) extreme.getText();
                    localData.register(extremePreferenceText,"PREFERENCE_EXTREME");
                    check = 0;
                }else{
                    extreme.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    music.setBackgroundResource(R.drawable.border_green_round2);
                    String musicPreferenceText = (String) music.getText();
                    localData.register(musicPreferenceText,"PREFERENCE_MUSIC");
                    check = 0;
                }else{
                    music.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    drink.setBackgroundResource(R.drawable.border_green_round2);
                    String drinkPreferenceText = (String) drink.getText();
                    localData.register(drinkPreferenceText,"PREFERENCE_DRINK");
                    check = 0;
                }else{
                    drink.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if(check == 1){
                    games.setBackgroundResource(R.drawable.border_green_round2);
                    String gamesPreferenceText = (String) games.getText();
                    localData.register(gamesPreferenceText,"PREFERENCE_GAMES");
                    check = 0;
                }else{
                    games.setBackgroundResource(R.drawable.border_green_soft_transparent_round);
                    localData.getRegister("");
                    check = 1;
                }
            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register4();
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