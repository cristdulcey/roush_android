package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeData {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("person1")
    @Expose
    private String person1;

    @SerializedName("person2")
    @Expose
    private String person2;

    @SerializedName("response_person1")
    @Expose
    private String response_person1;

    @SerializedName("response_person2")
    @Expose
    private String response_person2;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("person1_name")
    @Expose
    private String person1_name;

    @SerializedName("person2_name")
    @Expose
    private String person2_name;


    public HomeData(String id, String person1, String person2, String response_person1, String response_person2) {
        this.id = id;
        this.person1 = person1;
        this.person2 = person2;
        this.response_person1 = response_person1;
        this.response_person2 = response_person2;
    }
    public HomeData(String response_person1, String response_person2) {
        this.response_person1 = response_person1;
        this.response_person2 = response_person2;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1 = person1;
    }

    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2 = person2;
    }

    public String isResponse_person1() {
        return response_person1;
    }

    public void setResponse_person1(String response_person1) {
        this.response_person1 = response_person1;
    }

    public String isResponse_person2() {
        return response_person2;
    }

    public void setResponse_person2(String response_person2) {
        this.response_person2 = response_person2;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPerson1_name() {
        return person1_name;
    }

    public void setPerson1_name(String person1_name) {
        this.person1_name = person1_name;
    }

    public String getPerson2_name() {
        return person2_name;
    }

    public void setPerson2_name(String person2_name) {
        this.person2_name = person2_name;
    }
}
