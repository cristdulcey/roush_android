package com.example.tinder_roush.Likes;

import com.example.tinder_roush.Objects.HomeData;

import java.util.ArrayList;

public interface LikesInterfaces {

    interface fragment{
        void showPhotoProfile(String data);
        void recyclerLikes(ArrayList<HomeData> listLikes);
        void recyclerLikesGiven(ArrayList<HomeData> listLikes);
    }

    interface presenters{
        void getPhotoProfile();
        void getPhotoProfileSuccess(String data);
        void getAllLikesPresenter();
        void getAllLikesRePresenter();
        void getLikesPresenter(ArrayList<HomeData> listLikes);
        void getLikesReceivedPresenter(ArrayList<HomeData> listLikes);
        void getLikesError(String message);
    }

    interface models{
        void getAllLikesReModel(LikesPresenters presenter);
        void getUserCurrentPhoto(presenters presenter);
        void getAllLikesModel(LikesPresenters likesPresenters);
    }
}
