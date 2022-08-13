package com.example.tinder_roush.Chats;

import com.example.tinder_roush.Likes.LikesPresenters;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Objects.HomeData;

import java.util.ArrayList;

public interface ChatsInterfaces {

    interface fragment{
        void showPhotoProfile(String data);
        void recyclerChats(ArrayList<ChatData> listLikes);
    }

    interface presenters{
        void getPhotoProfile();
        void getPhotoProfileSuccess(String data);
        void getChatsPresenter(String search);
        void getChatsSuccessful(ArrayList<ChatData> data);
        void getLikesError(String message);
    }

    interface models{
        void getUserCurrentPhoto(presenters presenter);
        void getChatsModel(presenters presenter, String search);
    }
}
