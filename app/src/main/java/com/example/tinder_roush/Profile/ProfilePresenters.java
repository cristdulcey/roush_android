package com.example.tinder_roush.Profile;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.ProfileData;

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
    public void ProfilePresenter() {
        model.ProfileModel(this);
    }

    @Override
    public void ProfileGetPhotoPresenter() {
        model.ProfilePhotoModel(this);
    }

    @Override
    public void ProfileShowPhotoPresenter() {
        model.ProfileShowPhotoModel(this);
    }

    @Override
    public void ProfileEditPresenter() {
        model.ProfileEditModel(this);
    }

    @Override
    public void ProfileSuccessful(ProfileData data) {
        view.showData1(data);
    }

    @Override
    public void ProfileEditSuccessful(ProfileData data) {
        view2.showData2(data);
    }

    @Override
    public void ProfileGetPhotoSuccessful(CardPersonItem data) {
        view.getPhoto(data);
    }

    @Override
    public void ProfileShowPhotoSuccessful(CardPersonItem data) {
        view.showPhoto(data);
    }

    @Override
    public void ProfileError(String message) {

    }

    @Override
    public void changeDataPresenter(ProfileData data) {
        model.changeDataModel(this,data);
    }

    @Override
    public void changeDataSuccessful() {
        view2.successChangeProfile();
    }

    @Override
    public void changeDataError(String message) {

    }
}
