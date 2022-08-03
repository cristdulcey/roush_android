package com.example.tinder_roush.Likes;

import com.example.tinder_roush.Objects.HomeData;

import java.util.ArrayList;

public interface LikesInterfaces {

    interface fragment{
        void recyclerLikes(ArrayList<HomeData> listLikes);
    }

    interface presenters{
        void getLikesPresenter();
        //void getLikesReceivedPresenter();
        void getLikesSuccessful(ArrayList<HomeData> data);
       // void getLikesReceivedSuccessful(HomeData data);
        void getLikesError(String message);
    }

    interface models{
        void getLikesModel(presenters presenter);
    }
}
