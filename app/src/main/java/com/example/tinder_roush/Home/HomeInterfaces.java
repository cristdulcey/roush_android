package com.example.tinder_roush.Home;

import com.example.tinder_roush.Objects.HomeData;

import java.util.ArrayList;

public interface HomeInterfaces {

    interface fragment{
       void addList(ArrayList<CardPersonItem> person);
      //  List<CardPersonItem> addList(String homeData);
    }

    interface presenters{
        void HomePresenterGetMatch();
        void HomePresenterGetPhotos(HomeData homeData);
        void HomePresenterSuccess(ArrayList<CardPersonItem> person);
        void HomeError(String message);
    }

    interface models{

        void HomeModelMatch(presenters presenter);

        void HomeModelPhoto(presenters presenter);
    }

}
