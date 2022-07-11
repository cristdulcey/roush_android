package com.example.tinder_roush.Api;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Objects.AccessTokenData;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.Register4Data;
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
import retrofit2.http.Query;

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

    @GET("/api/persons/get-data-person/")
    Call<ProfileData> current_user(
    );

    @POST("/api/persons-match/")
    Call<HomeData> persons_match(
    );

    @GET("/api/persons-photo/")
    Call<HomeResponse> persons_photo(
            @Query("person") String person
    );

    @PATCH("api/persons/{id}/")
    Call<ProfileData> changeProfile(
            @Path("id") String id,
            @Body MultipartBody profile
    );
    @GET("/api/persons-photo/")
    Call<CardPersonItem> persons_photo_id(
               @Query("person") String person
    );
    @GET("/api/persons-photo/{id}")
    Call<CardPersonItem> profile_photo(
            @Path("id") String id
    );

    @PATCH("api/persons-match/{id}/")
    Call<HomeData> match_response(
            @Path("id") String id,
            @Body MultipartBody response_1

    );

}
