package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register3Data {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("principal")
    @Expose
    private boolean principal;

    public Register3Data(String id, String image, boolean principal) {
        this.id = id;
        this.image = image;
        this.principal = principal;
    }

    public Register3Data(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() { return image; }
    public void setImage(String image) {
        this.image = image;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
