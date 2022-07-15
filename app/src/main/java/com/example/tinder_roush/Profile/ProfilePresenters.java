package com.example.tinder_roush.Profile;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;

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

    //GET PHOTO
    @Override
    public void ProfilePhotoUserPresenter() {
        model.ProfilePhotoModel(this);
    }

    @Override
    public void ProfilePhotoUserId(CardPersonItem person) {
        model.ProfileModelPhotoUser(this, person);
    }

    @Override
    public void ProfilePhotoUserSuccess(CardPersonItem person) {
        view.getPhoto(person);
    }

    //GET EDIT PHOTO
    @Override
    public void ProfilePhotoEditPresenter() {
        model.ProfileGetEditPhotoModel(this);
    }

    @Override
    public void ProfilePhotoUserEdit(CardPersonItem person) {
        model.ProfileModelGetEditPhoto(this,person);
    }

    @Override
    public void ProfilePhotoGetSuccess(CardPersonItem person) {
        view2.getPhoto(person);
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
    public void ProfileError(String message) { }

    @Override
    public void ProfileChangePhotoPresenters(CardPersonItem data) {
        model.changePhotoModel(this,data);
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
