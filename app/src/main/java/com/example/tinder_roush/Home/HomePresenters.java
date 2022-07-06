package com.example.tinder_roush.Home;

import android.view.View;

import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.Login.LoginModels;
import com.example.tinder_roush.Objects.HomeData;

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
    public void HomePresenterGetPhotos(HomeData data) {
        model.HomeModelPhoto(this);
    }

    @Override
    public void HomePresenterSuccess(String homeData) {
        view.addList();
    }

    @Override
    public void HomeError(String message) {

    }
}
