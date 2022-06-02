package com.example.tinder_roush.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tinder_roush.MatchSuccess.MatchSuccess;
import com.example.tinder_roush.MenuNavigation.MenuNavigation;
import com.example.tinder_roush.R;

public class HomeActivity extends Fragment {

    ImageButton match, swipe, like;
    Context context;
    public HomeActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_, container, false);
        context = view.getContext();
        initObjets(view);
        listeners();
        return view;
    }

    private void initObjets(View view){
        match = view.findViewById(R.id.match_button);
//        register = findViewById(R.id.button_make_account);
//        forgot_password = findViewById(R.id.button_forgot_password);
//        email = findViewById(R.id.field_email);
//        password = findViewById(R.id.field_password);
    }

    private void listeners() {
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performMatchSuccess();
            }
        });
    }

    public void performMatchSuccess(){
        Intent intent = new Intent(context, MatchSuccess.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}