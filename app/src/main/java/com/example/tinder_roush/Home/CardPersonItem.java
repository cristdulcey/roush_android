package com.example.tinder_roush.Home;

import com.example.tinder_roush.Objects.ProfileData;

public class CardPersonItem {

    private String id, image;
    private ProfileData person;

    public CardPersonItem() {
    }

    public CardPersonItem(String id, ProfileData person, String image) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProfileData getPerson() {
        return person;
    }

    public void setPerson(ProfileData person) {
        this.person = person;
    }
}
