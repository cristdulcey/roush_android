package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeResponse {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("person")
    @Expose
    private String person;

    @SerializedName("image")
    @Expose
    private String image;

    public HomeResponse(String id, String person, String image) {
        this.id = id;
        this.person = person;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
