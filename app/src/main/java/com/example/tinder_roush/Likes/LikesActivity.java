package com.example.tinder_roush.Likes;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import androidx.fragment.app.FragmentTransaction;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LikesActivity extends Fragment implements LikesInterfaces.fragment{

    private ArrayList<HomeData> listLikes;
    private RecyclerView recyclerViewLikes;
    private LikesAdapter likesAdapter;
    private LikesReceivedAdapter likesReceivedAdapter;
    int check_lg,check_lr;
    ImageView goProfile;
    Button given, received;
    LikesPresenters presenter;
    LocalData localData;
    public LikesActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_likes, container, false);
        initObjects(view);
        presenter.getAllLikesPresenter();
        presenter.getPhotoProfile();
        listeners();
        return view;
    }

    private void initObjects(View view) {
        check_lg =1; check_lr=1;
        given = view.findViewById(R.id.given_likes_button);
        received = view.findViewById(R.id.received_likes_button);
        goProfile = view.findViewById(R.id.profile_from_likes);
        recyclerViewLikes = view.findViewById(R.id.recycler_likes_given);
        presenter = new LikesPresenters(this);
        localData = new LocalData();
        listLikes = new ArrayList<>();
    }

    public void listeners(){
        given.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            if(check_lg == 1){
                presenter.getLikesPresenter();
                given.setBackgroundResource(R.drawable.border_left_green);
                given.setTextColor(Color.WHITE);
                received.setBackgroundResource(R.drawable.border_rigth_white);
                received.setTextColor(Color.GRAY);
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
                    presenter.getLikesReceivedPresenter();
                    given.setBackgroundResource(R.drawable.border_left_white);
                    given.setTextColor(Color.GRAY);
                    received.setBackgroundResource(R.drawable.border_rigth_green);
                    received.setTextColor(Color.WHITE);
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

    @Override
    public void showPhotoProfile(String data) {
        Picasso.get().load(data).fit().centerCrop().into(goProfile);
    }

    public void recyclerLikes(ArrayList<HomeData> listLikes){
        likesAdapter = new LikesAdapter(BaseContext.getContext(), listLikes);
        recyclerViewLikes.setAdapter(likesAdapter);
        recyclerViewLikes.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL,false));
    }
    public void recyclerLikesGiven(ArrayList<HomeData> listLikes){
        likesReceivedAdapter = new LikesReceivedAdapter(BaseContext.getContext(), listLikes);
        recyclerViewLikes.setAdapter(likesReceivedAdapter);
        recyclerViewLikes.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL,false));
    }
}