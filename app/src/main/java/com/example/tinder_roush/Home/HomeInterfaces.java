package com.example.tinder_roush.Home;

import com.example.tinder_roush.Objects.HomeData;

import java.util.ArrayList;

public interface HomeInterfaces {

    interface fragment{
       void addList(ArrayList<CardPersonItem> person);
        void matchResponse1Success();
        void matchResponse1Deny();

        void matchResponse2Success();
        void matchResponse2Deny();
        //  List<CardPersonItem> addList(String homeData);
    }

    interface presenters{
        void HomePresenterGetMatch();
        void HomePresenterGetPhotos();
        void HomePresenterSuccess(ArrayList<CardPersonItem> person);
        void HomeResponseMatch(HomeData homeData);
        void HomeBackResponseMatch(HomeData homeData);
        void HomeResponseMatchSuccess();


        void HomeError(String message);
    }

    interface models{

        void HomeModelMatch(presenters presenter);
        void HomeModelPhoto(presenters presenter);
        void HomeModelResponseMatch(presenters presenter, HomeData data);
    }

}
