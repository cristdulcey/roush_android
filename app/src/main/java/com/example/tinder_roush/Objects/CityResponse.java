package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CityResponse {
    @SerializedName("results")
    @Expose
    ArrayList<CityData> cities;

    public CityResponse(ArrayList<CityData> cities) {
        this.cities = cities;
    }

    public ArrayList<CityData> getCities() {
        return cities;
    }

    public void setCities(ArrayList<CityData> cities) {
        this.cities = cities;
    }
}
