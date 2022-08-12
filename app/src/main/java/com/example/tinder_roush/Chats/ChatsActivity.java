package com.example.tinder_roush.Chats;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tinder_roush.ChatDetail.ChatDetailActivity;
import com.example.tinder_roush.Likes.LikesAdapter;
import com.example.tinder_roush.Likes.LikesPresenters;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Objects.ChatResponse;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.RecyclerTouchListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatsActivity extends Fragment implements ChatsInterfaces.fragment {

    private RecyclerView recyclerViewChats;
    private ChatsAdapter chatsAdapter;
    ImageView goProfile;
    ChatsPresenters presenter;

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

    @Override
    public void onResume() {
        super.onResume();
        presenter.getChatsPresenter();
        presenter.getPhotoProfile();
    }

    private void initObjects(View view) {
        recyclerViewChats = view.findViewById(R.id.recycler_chats);
        recyclerViewChats.addOnItemTouchListener(new RecyclerTouchListener(BaseContext.getContext(), recyclerViewChats, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(BaseContext.getContext(), ChatDetailActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Log.e("click long",String.valueOf(position));
            }
        }));
        goProfile = view.findViewById(R.id.profile_from_chats);
        presenter = new ChatsPresenters(this);
    }
    public void listeners(){
        goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performToMyProfile();
            }
        });
    }


    @Override
    public void showPhotoProfile(String data) {
        Picasso.get().load(data).fit().centerCrop().into(goProfile);
    }

    @Override
    public void recyclerChats(ArrayList<ChatData> listChats){
        chatsAdapter = new ChatsAdapter(BaseContext.getContext(), listChats);
        recyclerViewChats.setAdapter(chatsAdapter);
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL,false));
    }

    public void performToMyProfile(){
        Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}