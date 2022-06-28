package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register1Data {

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

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;


    public Register1Data(String first_name, String last_name, String username, String date_birth, String city, String gender, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.date_birth = date_birth;
        this.city = city;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public Register1Data(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
