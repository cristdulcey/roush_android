package com.example.tinder_roush.Home;

import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.LoginData;

import java.util.ArrayList;
import java.util.List;

public interface HomeInterfaces {

    interface fragment{
        List<CardPersonItem> addList();
      //  List<CardPersonItem> addList(String homeData);
    }

    interface presenters{
        void HomePresenterGetMatch();
        void HomePresenterGetPhotos(HomeData homeData);
        void HomePresenterSuccess(String homeData);
        void HomeError(String message);
    }

    interface models{

        void HomeModelMatch(presenters presenter);

        void HomeModelPhoto(presenters presenter);
    }

}
