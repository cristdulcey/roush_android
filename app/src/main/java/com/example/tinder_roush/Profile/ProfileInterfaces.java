package com.example.tinder_roush.Profile;

import android.telecom.Call;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Home.HomeInterfaces;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;

public interface ProfileInterfaces {

    interface activities1{
        void getPhoto(CardPersonItem data);
        void showData1(ProfileData data);
    }
    interface activities2{
        void getPhoto(CardPersonItem data);
        void showData2(ProfileData data);
        void changeProfileData();
        void successChangeProfile();
    }

    interface presenters{
        void ProfilePresenter();

        //GET PHOTO
        void ProfilePhotoUserPresenter();
        void ProfilePhotoUserId(CardPersonItem person);
        void ProfilePhotoUserSuccess(CardPersonItem person);

        //EDIT PHOTO PROFILE
        void ProfilePhotoEditPresenter();
        void ProfilePhotoUserEdit(CardPersonItem person);
        void ProfilePhotoGetSuccess(CardPersonItem person);

        //EDIT PROFILE
        void ProfileEditPresenter();
        void ProfileSuccessful(ProfileData data);
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
        void ProfileEditModel(presenters presenter);

        //Get photo current user
        void ProfilePhotoModel(ProfileInterfaces.presenters presenter);
        void ProfileModelPhotoUser(ProfileInterfaces.presenters presenter, CardPersonItem data);

        //Edit get photo current user
        void ProfileGetEditPhotoModel(ProfileInterfaces.presenters presenter);
        void ProfileModelGetEditPhoto(ProfileInterfaces.presenters presenter, CardPersonItem data);

        void changeDataModel(presenters presenter, ProfileData data);
        void changePhotoModel(presenters presenter, CardPersonItem data);
    }

}
