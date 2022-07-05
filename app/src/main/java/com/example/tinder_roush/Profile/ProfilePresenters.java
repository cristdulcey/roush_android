package com.example.tinder_roush.Profile;

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
    public void ProfileSuccessful(ProfileData data) {
        view.showData1(data);
    }

    @Override
    public void ProfileError(String message) {

    }

    @Override
    public void changeDataPresenter(ProfileData data, String id_person, String photo) {

    }

    @Override
    public void changeDataSuccessful() {

    }

    @Override
    public void changeDataError(String message) {

    }
}
