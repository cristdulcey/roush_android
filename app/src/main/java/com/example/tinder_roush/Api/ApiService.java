package com.example.tinder_roush.Api;

import com.example.tinder_roush.Objects.AccessTokenData;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.Register4Data;
import com.example.tinder_roush.Objects.RegisterResponse;
import com.example.tinder_roush.Objects.TokenResponse;
import com.example.tinder_roush.Objects.UserData;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @FormUrlEncoded
    @POST("api/token/")
    Call<TokenResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/api/token/refresh/")
    Call<AccessTokenData> refreshToken(
            @Field("refresh") String refresh
    );

    @FormUrlEncoded
    @POST("/api/token/verify/")
    Call<ResponseBody> verifyToken(
            @Field("token") String token
    );

    @GET("/api/cities/")
    Call<CityResponse> cities(
    );

//    @POST("/api/persons/")
    @POST("/api/persons/")
    Call<UserData> sendInfo(
            @Body MultipartBody body
    );

    @POST("/api/persons-photo/")
    Call<Register3Data> addPhoto(
            @Body MultipartBody body
    );

    @PATCH("/api/persons/{id}/")
    Call<Register4Data> addInterest(
            @Path("id") String id,
            @Body MultipartBody body
    );

}
