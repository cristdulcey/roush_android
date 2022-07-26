package com.example.tinder_roush.Likes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tinder_roush.Objects.LikesData;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class LikesActivity extends Fragment {

    private ArrayList<LikesData> listLikes;

    private RecyclerView recyclerViewLikes;
    private LikesAdapter likesAdapter;
    int check_lg,check_lr;
    ImageView goProfile;
    Button given, received;
    public LikesActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_likes, container, false);
        initObjects(view);
        listeners();
//        setLikesInfo();
//        recyclerLikes();
        return view;
    }

    private void initObjects(View view) {
        check_lg =1; check_lr=1;
        given = view.findViewById(R.id.given_likes_button);
        received = view.findViewById(R.id.received_likes_button);
        goProfile = view.findViewById(R.id.profile_from_likes);
        recyclerViewLikes = view.findViewById(R.id.recycler_likes_received);
        listLikes = new ArrayList<>();
    }

    public void listeners(){
        given.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            if(check_lg == 1){
                given.setBackgroundResource(R.drawable.border_left_green);
                given.setTextColor(Color.WHITE);
                received.setBackgroundResource(R.drawable.border_rigth_white);
                received.setTextColor(Color.GRAY);
                LikesGivenReceivedFragment LikesGivenReceived = new LikesGivenReceivedFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.view_likes, LikesGivenReceived);
                transaction.commit();
                check_lg = 0;
            }else{
                check_lg = 1;
            }
            }
        });

        received.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_lr == 1){
                    given.setBackgroundResource(R.drawable.border_left_white);
                    given.setTextColor(Color.GRAY);
                    received.setBackgroundResource(R.drawable.border_rigth_green);
                    received.setTextColor(Color.WHITE);
                    LikesGivenReceivedFragment LikesGivenReceived = new LikesGivenReceivedFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.view_likes, LikesGivenReceived);
                    transaction.commit();
                    check_lr = 0;
                }
                else{
                    check_lr = 1;
                }
            }
        });

        goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performToMyProfile();
            }
        });
    }

    public void performToMyProfile(){
        Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

//    public void recyclerLikes(ArrayList<LikesData> listLikes){
//        likesAdapter = new LikesAdapter(BaseContext.getContext(), listLikes);
//        recyclerView.setAdapter(likesAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL,false));
//    }
//    public void setLikesInfo(){
//        listLikes.add(new LikesData("Alguien"));
//        listLikes.add(new LikesData("Juan"));
//        listLikes.add(new LikesData("Camila"));
//        listLikes.add(new LikesData("Andres"));
//        listLikes.add(new LikesData("Lauren"));
//    }
}