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
        void getLikesPresenter();
        void getLikesReceivedPresenter();
        void getLikesSuccessful(ArrayList<HomeData> data);
        void getLikesReceivedSuccessful(ArrayList<HomeData> data);
        void getLikesError(String message);
    }

    interface models{
        void getUserCurrentPhoto(presenters presenter);
        void getLikesModel(presenters presenter);
        void getLikesReceivedModel(presenters presenter);
        void getAllLikesModel(LikesPresenters likesPresenters);
    }
}
