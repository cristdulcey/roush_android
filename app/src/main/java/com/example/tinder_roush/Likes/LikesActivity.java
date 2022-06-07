package com.example.tinder_roush.Likes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tinder_roush.R;

import java.util.ArrayList;

public class LikesActivity extends Fragment {

//    private RecyclerView recyclerView;
//    private LikesAdapter likesAdapter;

    Button given, received;
    public LikesActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // binding = FragmentLikesBinding.inflate(getLayoutInflater());

        View view = inflater.inflate(R.layout.fragment_likes, container, false);
        initObjects(view);
        listeners();
        return view;
    }

    private void initObjects(View view) {
        given = view.findViewById(R.id.given_likes_button);
        received = view.findViewById(R.id.received_likes_button);
      //  recyclerView = view.findViewById(R.id.recycler_likes_received);
    }

    public void listeners(){
        given.setOnClickListener(new View.OnClickListener() {
        @SuppressLint("ResourceAsColor")
        @Override
            public void onClick(View view) {
                given.setBackgroundResource(R.drawable.border_left_green);
                received.setBackgroundResource(R.drawable.border_rigth_white);
                given.setTextColor(R.color.gray);
                LikesGivenReceivedFragment LikesGivenReceived = new LikesGivenReceivedFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.view_likes, LikesGivenReceived);
                transaction.commit();
            }
        });

        received.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                given.setBackgroundResource(R.drawable.border_left_white);
                received.setBackgroundResource(R.drawable.border_rigth_green);
                given.setTextColor(R.color.white);
                LikesGivenReceivedFragment LikesGivenReceived = new LikesGivenReceivedFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.view_likes, LikesGivenReceived);
                transaction.commit();
            }
        });
    }
}