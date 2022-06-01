package com.example.tinder_roush.Register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinder_roush.R;
import com.example.tinder_roush.databinding.FragmentRegister2Binding;
import com.example.tinder_roush.databinding.FragmentRegister3Binding;

public class FragmentRegister3 extends Fragment {

    FragmentRegister3Binding binding;

    public FragmentRegister3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegister3Binding.inflate(inflater, container, false);

        listener();
        return binding.getRoot();
    }

    public void listener(){
        binding.nextR3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRegister4 Register4 = new FragmentRegister4();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register4);
                transaction.commit();
            }
        });

        binding.backR3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRegister2 Register2 = new FragmentRegister2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register2);
                transaction.commit();
            }
        });
    }
}