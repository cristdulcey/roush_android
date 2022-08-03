package com.example.tinder_roush.Likes;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.LikesData;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LikesModels implements LikesInterfaces.models{

    ApiAdapter apiAdapter;
    LocalData localData;

    public LikesModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }

    @Override
    public void getLikesModel(LikesInterfaces.presenters presenter) {
        Call<LikesData> call = apiAdapter.getApiService2().likes(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<LikesData>() {
            @Override
            public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                if (response.isSuccessful()){
                    LikesData list = response.body();
                    presenter.getLikesSuccessful(list.getResults());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Inténtalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.getLikesError(response_user);
                }
            }

            @Override
            public void onFailure(Call<LikesData> call, Throwable t) {

            }
        });
    }
}
