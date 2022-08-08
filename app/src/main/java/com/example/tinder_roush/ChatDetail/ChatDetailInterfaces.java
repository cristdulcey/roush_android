package com.example.tinder_roush.ChatDetail;

import com.example.tinder_roush.Objects.ChatData;

import java.util.ArrayList;

public interface ChatDetailInterfaces {

    interface fragment{
        void showPhotoProfile(String data);
        void recyclerChatsDetail(ArrayList<ChatData> listLikes);
    }

    interface presenters{
        void getPhotoProfile();
        void getPhotoProfileSuccess(String data);
        void getChatDetailPresenter();
        void getChatsSuccessful(ArrayList<ChatData> data);
        void getLikesError(String message);
    }

    interface models{
        void getUserCurrentPhoto(presenters presenter);
        void getChatsModel(presenters presenter);
    }
}
