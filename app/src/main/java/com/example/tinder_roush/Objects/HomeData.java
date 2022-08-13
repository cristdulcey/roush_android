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
    private boolean response_person1;

    @SerializedName("response_person2")
    @Expose
    private boolean response_person2;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("person1_name")
    @Expose
    private String person1_name;

    @SerializedName("person2_name")
    @Expose
    private String person2_name;

    @SerializedName("person1_image")
    @Expose
    private String person1_image;

    @SerializedName("person2_image")
    @Expose
    private String person2_image;


    @SerializedName("person1_job")
    @Expose
    private String person1_job;

    @SerializedName("person2_job")
    @Expose
    private String person2_job;

    @SerializedName("person1_date_birth")
    @Expose
    private String person1_date_birth;

    @SerializedName("person2_date_birth")
    @Expose
    private String person2_date_birth;

    public HomeData(String id, String person1, String person2, boolean response_person1, boolean response_person2, String created_at, String person1_name, String person2_name, String person1_image, String person2_image) {
        this.id = id;
        this.person1 = person1;
        this.person2 = person2;
        this.response_person1 = response_person1;
        this.response_person2 = response_person2;
        this.created_at = created_at;
        this.person1_name = person1_name;
        this.person2_name = person2_name;
        this.person1_image = person1_image;
        this.person2_image = person2_image;
    }

    public HomeData(String id, String person1, String person2, boolean response_person1, boolean response_person2, String created_at, String person1_name, String person2_name, String person1_image, String person2_image, String person1_job, String person2_job, String person1_date_birth, String person2_date_birth) {
        this.id = id;
        this.person1 = person1;
        this.person2 = person2;
        this.response_person1 = response_person1;
        this.response_person2 = response_person2;
        this.created_at = created_at;
        this.person1_name = person1_name;
        this.person2_name = person2_name;
        this.person1_image = person1_image;
        this.person2_image = person2_image;
        this.person1_job = person1_job;
        this.person2_job = person2_job;
        this.person1_date_birth = person1_date_birth;
        this.person2_date_birth = person2_date_birth;
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

    public boolean isResponse_person1() {
        return response_person1;
    }

    public void setResponse_person1(boolean response_person1) {
        this.response_person1 = response_person1;
    }

    public boolean isResponse_person2() {
        return response_person2;
    }

    public void setResponse_person2(boolean response_person2) {
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

    public String getPerson1_image() {
        return person1_image;
    }

    public void setPerson1_image(String person1_image) {
        this.person1_image = person1_image;
    }

    public String getPerson2_image() {
        return person2_image;
    }

    public void setPerson2_image(String person2_image) {
        this.person2_image = person2_image;
    }

    public String getPerson1_job() {
        return person1_job;
    }

    public void setPerson1_job(String person1_job) {
        this.person1_job = person1_job;
    }

    public String getPerson2_job() {
        return person2_job;
    }

    public void setPerson2_job(String person2_job) {
        this.person2_job = person2_job;
    }

    public String getPerson1_date_birth() {
        return person1_date_birth;
    }

    public void setPerson1_date_birth(String person1_date_birth) {
        this.person1_date_birth = person1_date_birth;
    }

    public String getPerson2_date_birth() {
        return person2_date_birth;
    }

    public void setPerson2_date_birth(String person2_date_birth) {
        this.person2_date_birth = person2_date_birth;
    }
}
