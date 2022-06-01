package com.example.tinder_roush.Register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinder_roush.R;
import com.example.tinder_roush.databinding.FragmentRegister1Binding;
import com.example.tinder_roush.databinding.FragmentRegister2Binding;

public class FragmentRegister2 extends Fragment {

    FragmentRegister2Binding binding;
    public FragmentRegister2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegister2Binding.inflate(inflater, container, false);

        listener();
        return binding.getRoot();
    }

    public void listener(){
        binding.nextR2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRegister3 Register3 = new FragmentRegister3();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register3);
                transaction.commit();
            }
        });

        binding.backR2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRegister1 Register1 = new FragmentRegister1();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register1);
                transaction.commit();
            }
        });
    }
}