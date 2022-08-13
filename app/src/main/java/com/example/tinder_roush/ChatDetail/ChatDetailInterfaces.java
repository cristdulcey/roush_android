package com.example.tinder_roush.ChatDetail;

import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Objects.ChatDetailData;

import java.util.ArrayList;

public interface ChatDetailInterfaces {

    interface fragment{
        void showPhotoProfile(String data);
        void recyclerChatsDetail(ArrayList<ChatDetailData> listLikes);
    }

    interface presenters{
        void getPhotoProfile();
        void getPhotoProfileSuccess(String data);
        void getChatDetailPresenter(String id_chat);
        void getChatsSuccessful(ArrayList<ChatDetailData> data);
        void getLikesError(String message);
    }

    interface models{
        void getUserCurrentPhoto(presenters presenter);
        void getChatsModel(presenters presenter, String id_chat);
    }
}
