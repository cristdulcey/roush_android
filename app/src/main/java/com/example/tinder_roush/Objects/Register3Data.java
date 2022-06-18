package com.example.tinder_roush.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register3Data {

    @SerializedName("image")
    @Expose
    private String image1;

    @SerializedName("image")
    @Expose
    private String image2;

    @SerializedName("image")
    @Expose
    private String image3;

    @SerializedName("image")
    @Expose
    private String image4;

    @SerializedName("image")
    @Expose
    private String image5;

    @SerializedName("image")
    @Expose
    private String image6;

    public Register3Data(String image1, String image2, String image3, String image4, String image5, String image6) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.image6 = image6;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImage6() {
        return image6;
    }

    public void setImage6(String image6) {
        this.image6 = image6;
    }
}
