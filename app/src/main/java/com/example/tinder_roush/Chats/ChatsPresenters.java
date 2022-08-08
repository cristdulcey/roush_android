package com.example.tinder_roush.Chats;

import android.widget.Toast;


import com.example.tinder_roush.Objects.ChatData;

import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class ChatsPresenters implements ChatsInterfaces.presenters{

    private ChatsInterfaces.fragment view;
    private ChatsModels model;
    private ChatsAdapter adapter;

    public ChatsPresenters(ChatsInterfaces.fragment view) {
        this.view = view;
        this.model = new ChatsModels();
    }

    //Photo
    @Override
    public void getPhotoProfile() {
        model.getUserCurrentPhoto(this);
    }


    @Override
    public void getPhotoProfileSuccess(String data) {
        view.showPhotoProfile(data);
    }

    //Likes
    @Override
    public void getChatsPresenter() {
        model.getChatsModel(this);
    }

    @Override
    public void getChatsSuccessful(ArrayList<ChatData> data) {
        view.recyclerChats(data);
    }

    @Override
    public void getLikesError(String message) {
        Toast.makeText(BaseContext.getContext(),"No se pudo obtener", Toast.LENGTH_SHORT).show();
    }

}
