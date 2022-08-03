package com.example.tinder_roush.Home;

import android.view.View;
import android.widget.Toast;

import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public class HomePresenters implements HomeInterfaces.presenters{

    private HomeInterfaces.fragment view;
    private HomeModels model;

    public HomePresenters(HomeInterfaces.fragment view) {
        this.view = view;
        this.model = new HomeModels();
    }

    @Override
    public void citiesPresenter() {
        model.citiesModels(this);
    }

    @Override
    public void citiesSuccessful(ArrayList<CityData> cities) {
        List<KeyPairBoolDataCustom> listArray0 = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            CityData originsList = cities.get(i);
            KeyPairBoolDataCustom h = new KeyPairBoolDataCustom();
            h.setId(originsList.getId());
            h.setExtra("lo que sea");
            h.setName(originsList.getName());
            h.setSelected(false);
            listArray0.add(h);
        }
        //view.addItemsSpinnerCity(listArray0);
    }

    @Override
    public void getUserPreferencesFilter(View view) {
        model.HomeFilterUserPreferences(view,this);
    }

    @Override
    public void HomeFilterSuccessful(View v,ProfileData data) {
        view.filters(v, data);
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
