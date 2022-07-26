package com.example.tinder_roush.Profile;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public class ProfilePresenters implements ProfileInterfaces.presenters{

    private ProfileInterfaces.activities1 view;
    private ProfileInterfaces.activities2 view2;
    private ProfileModels model;

    public ProfilePresenters(ProfileInterfaces.activities1 view, ProfileInterfaces.activities2 view2) {
        this.view = view;
        this.view2 = view2;
        this.model = new ProfileModels();
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
        view.addItemsSpinnerCity(listArray0);
    }


    //GET DATA
    @Override
    public void ProfilePresenter() {
        model.ProfileModel(this);
    }

    @Override
    public void ProfileInterestPresenter() {
        model.ProfileInterestModel(this);
    }

    //GET PHOTO
    @Override
    public void ProfilePhotoUserPresenter() {
        model.ProfilePhotoModel(this);
    }

    @Override
    public void ProfilePhotoUserSuccess(CardPersonItem person) {
        view.getPhoto(person);
    }

    @Override
    public void ProfileSuccessGetPhotos(ArrayList<CardPersonItem> person) {
        view.showPhotos(person);
    }
    @Override
    public void ProfileEditSuccessGetPhotos(ArrayList<CardPersonItem> person) {
        view2.showPhotos2(person);
    }

    //GET PROFILE EDIT PHOTO
    @Override
    public void ProfilePhotoEditPresenter() {
        model.ProfileGetEditPhotoModel(this);
    }

    @Override
    public void ProfilePhotoUserEdit(CardPersonItem person) { model.ProfileModelGetEditPhoto(this,person); }

    @Override
    public void ProfilePhotoGetSuccess(CardPersonItem person) {
        view2.getPhoto(person);
    }

    @Override
    public void ProfileEditPresenter() {
        model.ProfileEditModel(this);
    }



    //GET PHOTOS AND INTERESTING ON PROFILE EDIT ACTIVITY
    @Override
    public void ProfileEditInterestPresenter() {
        model.ProfileEditInterestModel(this);
    }

    @Override
    public void ProfileEditPresenterGetPhotos() {
        model.ProfileEditGetPhotosModel(this);
    }

    @Override
    public void ProfileInterestSuccessful(ProfileData data) {
        view.showInterest(data);
    }
    @Override
    public void ProfileEditInterestSuccessful(ProfileData data) {
        view2.showInterest2(data);
    }

    @Override
    public void ProfileSuccessful(ProfileData data) {
        view.showData1(data);
    }

    @Override
    public void ProfilePresenterGetPhotos() {
        model.ProfileModelPhotos(this);
    }

    @Override
    public void ProfileEditSuccessful(ProfileData data) {
        view2.showData2(data);
    }

    @Override
    public void ProfileError(String message) { }

    //CHANGE DATA AND PHOTOS
    @Override
    public void ProfileChangePhotoPresenters(CardPersonItem data) { model.changePhotoModel(this,data); }

    @Override
    public void changeDataPresenter(ProfileData data) {
        model.changeDataModel(this,data);
    }

    @Override
    public void changeDataSuccessful() {
        view2.successChangeProfile();
    }


    //CHANGE ALL PHOTOS
    @Override
    public void changeProfilePhotosPresenter(String id) {
        if (id.equals("")){
            model.postOtherPhotos(this);
        }else {
            model.changeGetAllPhotosModel(this,id);
        }
    }

    @Override
    public void changeInteresting() {
        model.changeInteresting(this);
    }

    @Override
    public void changePreferencesSearch() {
        model.changePreferencesSearch(this);
    }

    @Override
    public void changeDataError(String message) {

    }
}
