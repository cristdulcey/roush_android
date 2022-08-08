package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class ChatData {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("chat")
    @Expose
    private ArrayList<ChatDetailData> chat;

    @SerializedName("match")
    @Expose
    private HomeData match;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    public ChatData(String id, ArrayList<ChatDetailData> chat, HomeData match, String created_at) {
        this.id = id;
        this.chat = chat;
        this.match = match;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<ChatDetailData> getChat() {
        return chat;
    }

    public void setChat(ArrayList<ChatDetailData> chat) {
        this.chat = chat;
    }

    public HomeData getMatch() {
        return match;
    }

    public void setMatch(HomeData match) {
        this.match = match;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
