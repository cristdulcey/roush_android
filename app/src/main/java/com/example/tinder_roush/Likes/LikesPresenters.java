package com.example.tinder_roush.Likes;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.HomeData;

import java.util.ArrayList;

public class LikesPresenters implements LikesInterfaces.presenters{

    private LikesInterfaces.fragment view;
    private LikesModels model;
    private LikesAdapter adapter;

    public LikesPresenters(LikesInterfaces.fragment view) {
        this.view = view;
        this.model = new LikesModels();
    }


    @Override
    public void getLikesPresenter() {
        model.getLikesModel(this);
    }

//    @Override
//    public void getLikesReceivedPresenter() { }

    @Override
    public void getLikesSuccessful(ArrayList<HomeData> data) {
        view.recyclerLikes(data);
    }

    @Override
    public void getPhotosLikes() {
        model.getPhotosLikeModel(this);
    }

    @Override
    public void likesPhotosSuccess(CardPersonItem data) {

    }

//    @Override
//    public void getLikesReceivedSuccessful(HomeData data) { }

    @Override
    public void getLikesError(String message) {

    }

}
