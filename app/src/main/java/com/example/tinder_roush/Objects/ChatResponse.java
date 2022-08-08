package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChatResponse {
    @SerializedName("results")
    @Expose
    ArrayList<ChatData> chats;

    public ChatResponse(ArrayList<ChatData> chats) {
        this.chats = chats;
    }

    public ArrayList<ChatData> getChats() {
        return chats;
    }

    public void setChats(ArrayList<ChatData> chats) {
        this.chats = chats;
    }
}
