package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileData {

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

    @SerializedName("email")
    @Expose
    private String email;

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

    @SerializedName("year_start")
    @Expose
    private String year_start;

    @SerializedName("year_finish")
    @Expose
    private String year_finish;

    @SerializedName("distance")
    @Expose
    private String distance;

    @SerializedName("position")
    @Expose
    private String position;

    @SerializedName("about")
    @Expose
    private String about;

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("interesting")
    @Expose
    private String interesting;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("sexual_orientation")
    @Expose
    private String sexual_orientation;

    @SerializedName("with_children")
    @Expose
    private String with_children;

    @SerializedName("with_pets")
    @Expose
    private String with_pets;

    @SerializedName("zodiac_sign")
    @Expose
    private String zodiac_sign;

    @SerializedName("smoker")
    @Expose
    private String smoker;

    public ProfileData(String id, String username, String first_name, String last_name, String email, String address, String date_birth, String gender, String search, String about, String job, String interesting, String city) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.date_birth = date_birth;
        this.gender = gender;
        this.search = search;
        this.about = about;
        this.job = job;
        this.interesting = interesting;
        this.city = city;
    }

    //All data
    public ProfileData(String id, String username, String first_name, String last_name, String email, String address, String date_birth, String gender,
                       String search, String year_start, String year_finish, String distance, String position, String about, String job, String interesting,
                       String city, String sexual_orientation, String with_children, String with_pets, String zodiac_sign, String smoker) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.date_birth = date_birth;
        this.gender = gender;
        this.search = search;
        this.year_start = year_start;
        this.year_finish = year_finish;
        this.distance = distance;
        this.position = position;
        this.about = about;
        this.job = job;
        this.interesting = interesting;
        this.city = city;
        this.sexual_orientation = sexual_orientation;
        this.with_children = with_children;
        this.with_pets = with_pets;
        this.zodiac_sign = zodiac_sign;
        this.smoker = smoker;
    }
    //Constructor update
    public ProfileData(String id, String first_name, String last_name, String email, String date_birth, String about, String job) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_birth = date_birth;
        this.about = about;
        this.job = job;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSexual_orientation() {
        return sexual_orientation;
    }

    public void setSexual_orientation(String sexual_orientation) {
        this.sexual_orientation = sexual_orientation;
    }

    public String getWith_children() {
        return with_children;
    }

    public void setWith_children(String with_children) {
        this.with_children = with_children;
    }

    public String getWith_pets() {
        return with_pets;
    }

    public void setWith_pets(String with_pets) {
        this.with_pets = with_pets;
    }

    public String getZodiac_sign() {
        return zodiac_sign;
    }

    public void setZodiac_sign(String zodiac_sign) {
        this.zodiac_sign = zodiac_sign;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getYear_start() {
        return year_start;
    }

    public void setYear_start(String year_start) {
        this.year_start = year_start;
    }

    public String getYear_finish() {
        return year_finish;
    }

    public void setYear_finish(String year_finish) {
        this.year_finish = year_finish;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
