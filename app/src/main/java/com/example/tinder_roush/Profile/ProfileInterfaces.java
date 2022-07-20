package com.example.tinder_roush.Profile;

import android.telecom.Call;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Home.HomeInterfaces;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;

import java.util.ArrayList;

public interface ProfileInterfaces {

    interface activities1{
        void getPhoto(CardPersonItem data);
        void showData1(ProfileData data);
        void showInterest(ProfileData data);
        void showPhotos(ArrayList<CardPersonItem> person);

    }
    interface activities2{
        void getPhoto(CardPersonItem data);
        void showData2(ProfileData data);
        void changeProfileData();
        void successChangeProfile();
    }

    interface presenters{
        void ProfilePresenter();
        void ProfileInterestPresenter();
        void ProfileSuccessful(ProfileData data);
        void ProfilePresenterGetPhotos();

        //GET PHOTO
        void ProfilePhotoUserPresenter();
        void ProfilePhotoUserSuccess(CardPersonItem person);
        void ProfileSuccessGetPhotos(ArrayList<CardPersonItem> person);

        //EDIT PHOTO PROFILE
        void ProfilePhotosPresenter();
        void ProfilePhotoUserId(CardPersonItem person);
        void ProfilePhotoEditPresenter();
        void ProfilePhotoUserEdit(CardPersonItem person);
        void ProfilePhotoGetSuccess(CardPersonItem person);

        //EDIT PROFILE
        void ProfileEditPresenter();
        void ProfileInterestSuccessful(ProfileData data);
        void ProfileEditSuccessful(ProfileData data);
        void ProfileError(String message);

        //CHANGE PROFILE PHOTO
        void ProfileChangePhotoPresenters(CardPersonItem data);

        void changeDataPresenter(ProfileData data);
        void changeDataSuccessful();
        void changeDataError(String message);
    }

    interface models{
        void ProfileModel(presenters presenter);
        void ProfileInterestModel(presenters presenter);
        void ProfileEditModel(presenters presenter);
        void ProfileModelPhotos(presenters presenter);

        //Get photo current user
        void ProfilePhotoModel(ProfileInterfaces.presenters presenter);
        void ProfileAllPhotosModel(ProfileInterfaces.presenters presenter);
        void ProfileModelPhotoUser(ProfileInterfaces.presenters presenter, CardPersonItem data);

        //Edit get photo current user
        void ProfileGetEditPhotoModel(ProfileInterfaces.presenters presenter);
        void ProfileModelGetEditPhoto(ProfileInterfaces.presenters presenter, CardPersonItem data);

        void changeDataModel(presenters presenter, ProfileData data);
        void changePhotoModel(presenters presenter, CardPersonItem data);
    }

}
