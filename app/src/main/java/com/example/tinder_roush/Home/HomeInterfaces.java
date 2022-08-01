package com.example.tinder_roush.Home;

import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;

import java.util.ArrayList;

public interface HomeInterfaces {

    interface fragment{
       void addList(ArrayList<CardPersonItem> person);
       void getUser(ProfileData data);
       void getUserPhoto(CardPersonItem person);
       void performMatchSuccess();
    }

    interface presenters{
        //Get match and photos
        void HomePresenterGetMatch();
        void HomePresenterGetPhotos();
        void HomePresenterSuccess(ArrayList<CardPersonItem> person);

        //Get photo current user
        void HomePhotoUser();
        void HomePhotoUserId(CardPersonItem person);
        void HomePhotoUserSuccess(CardPersonItem person);

        //Get response match
        void HomeResponseMatchTrue();
        void HomeResponseMatchFalse();
        void HomeResponseMatchSuccess();
        void HomeBackResponseMatchSuccess();
        void HomePersonCurrent();
        void HomePersonCurrentSuccess(ProfileData data);

        void HomeError(String message);
    }

    interface models{
        //Get match and photos
        void HomeModelMatch(presenters presenter);
        void HomeModelPhoto(presenters presenter);
        //Get photo current user
        void HomeModelPhotoUser(presenters presenter);
        void HomeModelPhotoUserSuccess(presenters presenter, CardPersonItem data);

        //Get response match
        void HomeModelResponseMatchTrue(presenters presenter);
        void HomeModelResponseMatchFalse(presenters presenter);
        void HomeModelPersonCurrent(presenters presenter);

    }

}
