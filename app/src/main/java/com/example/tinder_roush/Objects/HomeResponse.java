package com.example.tinder_roush.Objects;

import com.example.tinder_roush.Home.CardPersonItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeResponse {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("results")
    @Expose
    private ArrayList<CardPersonItem> results;

    public HomeResponse(int count, String next, String previous, ArrayList<CardPersonItem> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<CardPersonItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<CardPersonItem> results) {
        this.results = results;
    }
}
