package com.example.tinder_roush.Home;

public class CardPersonItem {

    private String name, age;
    private String image;
    public CardPersonItem() {
    }

    public CardPersonItem(String image, String name, String age) {
        this.image = image;
        this.name = name;
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
