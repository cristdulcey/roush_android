package com.example.tinder_roush.OtherProfile;

import com.example.tinder_roush.Home.CardPersonItem;

import java.util.ArrayList;

public interface OtherProfileInterfaces {
    interface activities{
        void showOtherData(ArrayList<CardPersonItem> data);
    }
    interface presenters{
        void getOtherInformation();
        void getOtherInformationSuccess(ArrayList<CardPersonItem> data);
        void getOtherInformationError(String message);
    }
    interface models{
        void getOtherInformationModel(OtherProfileInterfaces.presenters presenter);
    }
}
