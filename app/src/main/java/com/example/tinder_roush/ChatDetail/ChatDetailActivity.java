package com.example.tinder_roush.ChatDetail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Wizard.Onboarding1;
import com.example.tinder_roush.Wizard.Onboarding2;
import com.example.tinder_roush.Wizard.Onboarding3;
import com.example.tinder_roush.Wizard.OnboardingAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatDetailActivity extends AppCompatActivity implements ChatDetailInterfaces.fragment {

    private RecyclerView recyclerViewChatsDetail;
    private ChatDetailAdapter ChatDetailAdapter;
    ImageView goMyProfile;
    ChatDetailPresenters presenter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chats_detail);
        initObjects();
        listeners();
    }



    private void initObjects() {
        recyclerViewChatsDetail = findViewById(R.id.recycler_chats);
        goMyProfile = findViewById(R.id.profile_from_chats);
        presenter = new ChatDetailPresenters(this);
//        presenter.getChatsDetailPresenter();
        presenter.getPhotoProfile();
    }
    public void listeners(){
        goMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performToMyProfile();
            }
        });
    }


    @Override
    public void showPhotoProfile(String data) {
        Picasso.get().load(data).fit().centerCrop().into(goMyProfile);
    }

    @Override
    public void recyclerChatsDetail(ArrayList<ChatData> listChatsDetail){
        ChatDetailAdapter = new ChatDetailAdapter(BaseContext.getContext(), listChatsDetail);
        recyclerViewChatsDetail.setAdapter(ChatDetailAdapter);
        recyclerViewChatsDetail.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL,false));
    }

    public void performToMyProfile(){
        Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}