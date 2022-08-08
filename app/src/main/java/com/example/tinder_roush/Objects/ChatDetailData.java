package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatDetailData {
    @SerializedName("person_id")
    @Expose
    private String person_id;

    @SerializedName("person")
    @Expose
    private String person;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    public ChatDetailData(String person_id, String person, String message, String created_at) {
        this.person_id = person_id;
        this.person = person;
        this.message = message;
        this.created_at = created_at;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
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
