package com.example.tinder_roush.Home;

import android.view.View;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public class HomePresenters implements HomeInterfaces.presenters{

    private HomeInterfaces.fragment view;
    private HomeModels model;
    LocalData localData = new LocalData();

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
       // view.addItemsSpinnerCity(listArray0);
    }

    //FILTER
    @Override
    public void getUserPreferencesFilter(View view) {
        model.HomeFilterUserPreferences(view,this);
    }

    @Override
    public void HomeFilterSuccessful(View v,ProfileData data) {
        view.filters(v, data);
    }

    @Override
    public void HomePhotoUser() {
        model.getUserCurrentPhoto(this);
    }

    @Override
    public void getPhotoProfileSuccess(String data) {
        view.getUserPhoto(data);
    }

    @Override
    public void HomePresenterPostMatch() {
        model.HomeModelPostMatch(this);
    }

    @Override
    public void HomePresenterSuccess(ArrayList<HomeData> person) {
        view.addList(person);
    }

    //MATCH RESPONSES
    @Override
    public void HomeResponseMatchTrue() {
        model.HomeModelResponseMatchTrue(this);
    }

    @Override
    public void HomeResponseMatchFalse() {
        model.HomeModelResponseMatchFalse(this);
    }

    @Override
    public void HomeBackResponseMatchSuccess() {
        view.performMatchSuccess();
    }

    //GET USER CURRENT DATA
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
