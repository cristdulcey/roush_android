package com.example.tinder_roush.Profile;

import android.telecom.Call;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Home.HomeInterfaces;
import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public interface ProfileInterfaces {

    interface activities1{
        void getPhoto(CardPersonItem data);
        void showData1(ProfileData data);
        void showInterest(ProfileData data);
        void showPhotos(ArrayList<CardPersonItem> person);
        void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities);

    }
    interface activities2{
        void getPhoto(CardPersonItem data);
        void showData2(ProfileData data);
        void changeProfileData();
        void successChangeProfile();
        void showInterest2(ProfileData data);
        void showPhotos2(ArrayList<CardPersonItem> person);
        void addItemsSpinnerCity2(List<KeyPairBoolDataCustom> cities);
    }

    interface presenters{
        void citiesPresenter();

        void citiesPresenterEdit();

        void citiesSuccessful(ArrayList<CityData> cities);
        void citiesSuccessfulEdit(ArrayList<CityData> cities);
        void ProfilePresenter();
        void ProfileInterestPresenter();
        void ProfileSuccessful(ProfileData data);
        void ProfilePresenterGetPhotos();
        void ProfileInterestSuccessful(ProfileData data);

        //GET PHOTO
        void ProfilePhotoUserPresenter();
        void ProfilePhotoUserSuccess(CardPersonItem person);
        void ProfileSuccessGetPhotos(ArrayList<CardPersonItem> person);

        //EDIT PHOTO PROFILE
        void ProfilePhotoEditPresenter();
        void ProfilePhotoUserEdit(CardPersonItem person);
        void ProfilePhotoGetSuccess(CardPersonItem person);

        //EDIT PROFILE
        void ProfileEditPresenter();
        void ProfileEditInterestPresenter();
        void ProfileEditPresenterGetPhotos();
        void ProfileEditSuccessGetPhotos(ArrayList<CardPersonItem> person);
        void ProfileEditInterestSuccessful(ProfileData data);
        void ProfileEditSuccessful(ProfileData data);
        void ProfileError(String message);

        //CHANGE PROFILE PHOTO
        void ProfileChangePhotoPresenters(CardPersonItem data);
        void changeDataPresenter(ProfileData data);
        void changeDataSuccessful();
        void changeProfilePhotosPresenter(String id);
        void changeInteresting();
        void changePreferencesSearch();
        void changeDataError(String message);
    }

    interface models{
        void citiesModels(presenters presenter);
        void citiesModels2(presenters presenter);
        void ProfileModel(presenters presenter);
        void ProfileInterestModel(presenters presenter);
        void ProfileEditModel(presenters presenter);
        void ProfileModelPhotos(presenters presenter);

        //Get photo current user
        void ProfilePhotoModel(ProfileInterfaces.presenters presenter);

        //Edit get photo current user
        void ProfileGetEditPhotoModel(ProfileInterfaces.presenters presenter);
        void ProfileModelGetEditPhoto(ProfileInterfaces.presenters presenter, CardPersonItem data);
        void ProfileEditInterestModel(presenters presenter);
        void ProfileEditGetPhotosModel(presenters presenter);

       //Changes
        void changeDataModel(presenters presenter, ProfileData data);
        void changePhotoModel(presenters presenter, CardPersonItem data);
        void changeGetAllPhotosModel(presenters presenter, String id);
        void postOtherPhotos(presenters presenter);
        void changeInteresting(presenters presenter);
        void changePreferencesSearch(presenters presenter);
    }

}
