package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("date_birth")
    @Expose
    private String date_birth;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("document_type")
    @Expose
    private String document_type;

    @SerializedName("document")
    @Expose
    private String document;

    @SerializedName("search")
    @Expose
    private String search;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("about")
    @Expose
    private String about;

    @SerializedName("interesting")
    @Expose
    private String interesting;

    public RegisterResponse(String id, String first_name, String last_name, String username, String date_birth, String address, String gender, String email, String phone, String document_type, String document, String search, String city, String job, String about, String interesting) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.date_birth = date_birth;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.document_type = document_type;
        this.document = document;
        this.search = search;
        this.city = city;
        this.job = job;
        this.about = about;
        this.interesting = interesting;
    }

    public RegisterResponse(String id, String first_name, String last_name, String username) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting;
    }
}
