package com.example.tinder_roush.LocalData;

import android.content.SharedPreferences;

import com.example.tinder_roush.Utils.BaseContext;

public class LocalData implements LocalDataInterface{
    @Override
    public void LogOutApp() {
        String token = "";
        SharedPreferences preferences = BaseContext.getContext().getSharedPreferences("Tinder-roush", BaseContext.getContext().MODE_PRIVATE);
        preferences.edit().putString("REFRESH", "").apply();
        preferences.edit().putString("ACCESS", "").apply();
    }

    @Override
    public void saveToken(String refresh, String access) {
        SharedPreferences preferences = BaseContext.getContext().getSharedPreferences("Tinder-roush", BaseContext.getContext().MODE_PRIVATE);
        preferences.edit().putString("REFRESH", refresh).apply();
        preferences.edit().putString("ACCESS", access).apply();
    }

    @Override
    public String getRefresh() {
        SharedPreferences preferences = BaseContext.getContext().getSharedPreferences("Tinder-roush", BaseContext.getContext().MODE_PRIVATE);
        final String refresh = preferences.getString("REFRESH", null);
        if (refresh != null) {
            return refresh;
        }
        return "";
    }

    @Override
    public String getAccess() {
        SharedPreferences preferences = BaseContext.getContext().getSharedPreferences("Tinder-roush", BaseContext.getContext().MODE_PRIVATE);
        final String access = preferences.getString("ACCESS", null);
        if (access != null) {
            return access;
        }
        return "";
    }

    @Override
    public String getToken() {
        SharedPreferences preferences = BaseContext.getContext().getSharedPreferences("Tinder-roush", BaseContext.getContext().MODE_PRIVATE);
        final String token = preferences.getString("TOKEN", null);
        if (token != null) {
            return token;
        }
        return "";
    }
}
