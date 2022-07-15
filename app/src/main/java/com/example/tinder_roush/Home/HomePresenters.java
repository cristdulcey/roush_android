package com.example.tinder_roush.Home;

import android.widget.Toast;

import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class HomePresenters implements HomeInterfaces.presenters{

    private HomeInterfaces.fragment view;
    private HomeModels model;

    public HomePresenters(HomeInterfaces.fragment view) {
        this.view = view;
        this.model = new HomeModels();
    }

    @Override
    public void HomePresenterGetMatch() {
        model.HomeModelMatch(this);
    }

    @Override
    public void HomePresenterGetPhotos() {
        model.HomeModelPhoto(this);
    }

    @Override
    public void HomePresenterSuccess(ArrayList<CardPersonItem> person) {
        view.addList(person);
    }

    @Override
    public void HomePhotoUser() {
        model.HomeModelPhotoUser(this);
    }

    @Override
    public void HomePhotoUserId(CardPersonItem person) {
       model.HomeModelPhotoUserSuccess(this, person);
    }

    @Override
    public void HomePhotoUserSuccess(CardPersonItem person) {
        view.getUserPhoto(person);
    }

    @Override
    public void HomeResponseMatchTrue() {
        model.HomeModelResponseMatchTrue(this);
    }

    @Override
    public void HomeResponseMatchFalse() {
        model.HomeModelResponseMatchFalse(this);
    }

    @Override
    public void HomeResponseMatchSuccess() {
     //   Toast.makeText(BaseContext.getContext(), "Match request", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void HomeBackResponseMatchSuccess() {
        view.performMatchSuccess();
    }

    @Override
    public void HomePersonCurrent() {
        model.HomeModelPersonCurrent(this);
    }

    @Override
    public void HomePersonCurrentSuccess(ProfileData data) {
        view.getUser(data);
    }


    @Override
    public void HomeError(String message) {

    }
}
