package com.example.tinder_roush.Chats;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tinder_roush.Likes.LikesAdapter;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

public class ChatsActivity extends Fragment {

    private RecyclerView recyclerViewChats;
    private ChatsAdapter chatsAdapter;
    ImageView goMyProfile;

    public ChatsActivity() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        initObjects(view);
        listeners();
        return view;
    }

    private void initObjects(View view) {
        recyclerViewChats = view.findViewById(R.id.recycler_chats);
        goMyProfile = view.findViewById(R.id.profile_from_chats);
    }
    public void listeners(){
        goMyProfile.setOnClickListener(new View.OnClickListener() {
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
}