package com.example.tinder_roush.ChatDetail;

import android.widget.Toast;

import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Objects.ChatDetailData;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class ChatDetailPresenters implements ChatDetailInterfaces.presenters{

    private ChatDetailInterfaces.fragment view;
    private ChatDetailModels model;
    private ChatDetailAdapter adapter;

    public ChatDetailPresenters(ChatDetailInterfaces.fragment view) {
        this.view = view;
        this.model = new ChatDetailModels();
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
    public void getChatDetailPresenter(String id_chat) {
        model.getChatsModel(this, id_chat);
    }

    @Override
    public void getChatsSuccessful(ArrayList<ChatDetailData> data) {
        view.recyclerChatsDetail(data);
    }

    @Override
    public void getLikesError(String message) {
        Toast.makeText(BaseContext.getContext(),"No se pudo obtener", Toast.LENGTH_SHORT).show();
    }

}
