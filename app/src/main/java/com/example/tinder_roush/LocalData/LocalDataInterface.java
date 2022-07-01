package com.example.tinder_roush.LocalData;

public interface LocalDataInterface {

    void LogOutApp();

    void deleteUserCurrent();
    void deleteInterest();

    void saveToken(String refresh, String access);
    String getRefresh();
    String getAccess();
    void register(String data, String key);
    void CreateUser();
    void wizard();
    Boolean getwizard();
    String getToken();
}
