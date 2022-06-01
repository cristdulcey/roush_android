package com.example.tinder_roush.LocalData;

public interface LocalDataInterface {

    void LogOutApp();
    void saveToken(String refresh, String access);
    String getRefresh();
    String getAccess();

}
