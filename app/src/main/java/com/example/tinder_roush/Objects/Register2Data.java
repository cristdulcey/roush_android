package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register2Data {

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("about")
    @Expose
    private String about;

    @SerializedName("search")
    @Expose
    private String search;

    public Register2Data(String job, String about, String search) {
        this.job = job;
        this.about = about;
        this.search = search;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
