package com.example.tinder_roush.Likes;

import android.widget.Toast;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class LikesPresenters implements LikesInterfaces.presenters{

    private LikesInterfaces.fragment view;
    private LikesModels model;
    private LikesAdapter adapter;

    public LikesPresenters(LikesInterfaces.fragment view) {
        this.view = view;
        this.model = new LikesModels();
    }

    //Photo
    @Override
    public void getPhotoProfile() {
        model.getUserCurrentPhoto(this);
    }

//    @Override
//    public void getPhotoProfileId(String url) {
//        model.getUserPhoto(this,url);
//    }

    @Override
    public void getPhotoProfileSuccess(String data) {
        view.showPhotoProfile(data);
    }

    //Likes
    @Override
    public void getAllLikesPresenter() {
        model.getAllLikesModel(this);
    }

    @Override
    public void getAllLikesPresenter() {
        model.getAllLikesModel(this);
    }

    @Override
    public void getLikesPresenter() {
        model.getLikesModel(this);
    }

    @Override
    public void getLikesReceivedPresenter() {
        model.getLikesReceivedModel(this);
    }

    @Override
    public void getLikesSuccessful(ArrayList<HomeData> data) {
        view.recyclerLikes(data);
    }

    @Override
    public void getLikesReceivedSuccessful(ArrayList<HomeData> data) {
        view.recyclerLikesGiven(data);
    }

    @Override
    public void getLikesError(String message) {
        Toast.makeText(BaseContext.getContext(),"No se pudo obtener", Toast.LENGTH_SHORT).show();
    }

}
