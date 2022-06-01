package com.example.tinder_roush.Register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tinder_roush.R;
import com.example.tinder_roush.databinding.FragmentRegister1Binding;

public class FragmentRegister1 extends Fragment {

    FragmentRegister1Binding binding;

    public FragmentRegister1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRegister1Binding.inflate(inflater, container, false);

        binding.nextR1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRegister2 Register2 = new FragmentRegister2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register2);
                transaction.commit();
            }
        });

        return binding.getRoot();
    }
}