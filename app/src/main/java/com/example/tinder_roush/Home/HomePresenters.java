package com.example.tinder_roush.Home;

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
    public void HomePresenterSuccess(ArrayList<CardPersonItem> person) {

        view.addList(person);
    }

    @Override
    public void HomeError(String message) {

    }
}
