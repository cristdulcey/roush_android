package com.example.tinder_roush.Home;

public class CardPersonItem {

    private int image;
    private String name, age;

    public CardPersonItem() {
    }

    public CardPersonItem(int image, String name, String age) {
        this.image = image;
        this.name = name;
        this.age = age;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
