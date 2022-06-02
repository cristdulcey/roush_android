package com.example.tinder_roush.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tinder_roush.R;
import com.example.tinder_roush.RecoveryPassword.RecoveryPasswordActivity;

public class FragmentRegister4 extends Fragment {

    Button photo, create_account, shop, karaoke, yoga, cook, tennis, sports, swim, art, travel, extreme, music, drink, games;

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
        create_account = view.findViewById(R.id.create_account_final);
        photo = view.findViewById(R.id.button_photography);
    }

    public void listeners(){
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photo.setBackgroundResource(R.drawable.border_green_round2);
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SuccesRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}