package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatDetailData {

    @SerializedName("sender")
    @Expose
    private String person;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("date")
    @Expose
    private String created_at;

    public ChatDetailData(String person, String message, String created_at) {
        this.person = person;
        this.message = message;
        this.created_at = created_at;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
