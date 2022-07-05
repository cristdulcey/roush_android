package com.example.tinder_roush.Profile;

import com.example.tinder_roush.Objects.ProfileData;

public interface ProfileInterfaces {

    interface activities1{
        void showData1(ProfileData data);
    }
    interface activities2{
        void showData2(ProfileData data);
        void changeProfileData();
        void successChangeProfile();
    }

    interface presenters{
        void ProfilePresenter();
        void ProfileSuccessful(ProfileData data);
        void ProfileError(String message);

        void changeDataPresenter(ProfileData data, String id_person, String photo);
        void changeDataSuccessful();
        void changeDataError(String message);
    }

    interface models{
        void ProfileModel(presenters presenter);
        void changeDataModel(presenters presenter, ProfileData data, String id_person, String photo);
    }

}
