package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("document_type")
    @Expose
    private String document_type;

    @SerializedName("document")
    @Expose
    private String document;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("date_birth")
    @Expose
    private String date_birth;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("search")
    @Expose
    private String search;

//    @SerializedName("match")
//    @Expose
//    private String match;
//
//    @SerializedName("year_start")
//    @Expose
//    private String year_start;
//
//    @SerializedName("year_finish")
//    @Expose
//    private String year_finish;

//    @SerializedName("distance")
//    @Expose
//    private String distance;

//    @SerializedName("position")
//    @Expose
//    private String position;

    @SerializedName("about")
    @Expose
    private String about;

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("interesting")
    @Expose
    private String interesting;

    public UserData(String username, String first_name, String last_name, String email, String password, String address, String date_birth, String gender) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.date_birth = date_birth;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

//    public String getMatch() {
//        return match;
//    }
//
//    public void setMatch(String match) {
//        this.match = match;
//    }
//
//    public String getYear_start() {
//        return year_start;
//    }
//
//    public void setYear_start(String year_start) {
//        this.year_start = year_start;
//    }
//
//    public String getYear_finish() {
//        return year_finish;
//    }
//
//    public void setYear_finish(String year_finish) {
//        this.year_finish = year_finish;
//    }
//
//    public String getDistance() {
//        return distance;
//    }
//
//    public void setDistance(String distance) {
//        this.distance = distance;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting;
    }
}
