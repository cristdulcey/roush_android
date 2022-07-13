package com.example.tinder_roush.Home;

import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.ProfileData;

import java.util.ArrayList;

public interface HomeInterfaces {

    interface fragment{
       void addList(ArrayList<CardPersonItem> person);
       void getUser(ProfileData data);
//        void matchResponseSuccess();
//        void matchResponseDeny();
        void performMatchSuccess();
        //  List<CardPersonItem> addList(String homeData);
    }

    interface presenters{
        void HomePresenterGetMatch();
        void HomePresenterGetPhotos();
        void HomePresenterSuccess(ArrayList<CardPersonItem> person);
        void HomeResponseMatchTrue();
        void HomeResponseMatchFalse();
        void HomeResponseMatchSuccess();
        void HomeBackResponseMatchSuccess();
        void HomePersonCurrent();
        void HomePersonCurrentSuccess(ProfileData data);

        void HomeError(String message);
    }

    interface models{

        void HomeModelMatch(presenters presenter);
        void HomeModelPhoto(presenters presenter);
       // void HomeModelResponseMatch(presenters presenter, HomeData data);
        void HomeModelResponseMatchTrue(presenters presenter);
        void HomeModelResponseMatchFalse(presenters presenter);
        void HomeModelPersonCurrent(presenters presenter);

    }

}
