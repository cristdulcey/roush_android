package com.example.tinder_roush.Objects;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessTokenData {

    @SerializedName("access")
    @Expose
    private String access;

    public AccessTokenData(String access) {
        this.access = access;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

}
