package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register4Data {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("interesting")
    @Expose
    private String interesting;

    public Register4Data(String id, String interesting) {
        this.id = id;
        this.interesting = interesting;
    }

    public Register4Data(String interesting) {
        this.interesting = interesting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInteresting() { return interesting; }
    public void setInteresting(String image) {
        this.interesting = image;
    }
}
