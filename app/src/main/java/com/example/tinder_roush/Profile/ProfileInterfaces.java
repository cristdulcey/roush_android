package com.example.tinder_roush.Profile;

import android.telecom.Call;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;

public interface ProfileInterfaces {

    interface activities1{
        void showPhoto(CardPersonItem data);
        void getPhoto(CardPersonItem data);
        void showData1(ProfileData data);
    }
    interface activities2{
        void showData2(ProfileData data);
        void changeProfileData();
        void successChangeProfile();
    }

    interface presenters{
        void ProfilePresenter();
        void ProfileGetPhotoPresenter();
        void ProfileShowPhotoPresenter();
        void ProfileEditPresenter();
        void ProfileSuccessful(ProfileData data);
        void ProfileEditSuccessful(ProfileData data);
        void ProfileGetPhotoSuccessful(CardPersonItem data);
        void ProfileShowPhotoSuccessful(CardPersonItem data);
        void ProfileError(String message);

        void changeDataPresenter(ProfileData data);
        void changeDataSuccessful();
        void changeDataError(String message);
    }

    interface models{
        void ProfileModel(presenters presenter);
        void ProfileEditModel(presenters presenter);
        void ProfilePhotoModel(presenters presenter);
        void ProfileShowPhotoModel(presenters presenter);
        void changeDataModel(presenters presenter, ProfileData data);
    }

}
