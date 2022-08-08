package com.example.tinder_roush.Likes;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.HomeResponse;
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
    public void getAllLikesModel(LikesPresenters presenter) {
        Call<HomeData> call = apiAdapter.getApiService2().likes();
        call.enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                if (response.isSuccessful()) {
                    localData.register(response.body().getPerson1(),"PER_1");
                    localData.register(response.body().getPerson2(),"PER_2");
                    presenter.getLikesPresenter();
                } else {
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
            public void onFailure(Call<HomeData> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUserCurrentPhoto(LikesInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().profile(localData.getRegister("ID_USERCURRENT"), true);
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    presenter.getPhotoProfileSuccess(response.body().getResults().get(0).getImage());
                } else {
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
            public void onFailure(Call<HomeResponse> call, Throwable t) { }
        });
    }

    @Override
    public void getLikesModel(LikesInterfaces.presenters presenter) {
        if (localData.getRegister("ID_USERCURRENT").equals("PER_1")){
            Call<LikesData> call = apiAdapter.getApiService2().likes_given(localData.getRegister("PER_1"));
            call.enqueue(new Callback<LikesData>() {
                @Override
                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                    if (response.isSuccessful()) {
                        LikesData list = response.body();
                        presenter.getLikesSuccessful(list.getResults());
                    } else {
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
                public void onFailure(Call<LikesData> call, Throwable t) {}
            });
        } else {
            Call<LikesData> call = apiAdapter.getApiService2().likes_given(localData.getRegister("PER_1"));
            call.enqueue(new Callback<LikesData>() {
                @Override
                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                    if (response.isSuccessful()) {
                        LikesData list = response.body();
                        presenter.getLikesSuccessful(list.getResults());
                    } else {
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
                public void onFailure(Call<LikesData> call, Throwable t) { }
            });
        }
    }

    @Override
    public void getLikesReceivedModel(LikesInterfaces.presenters presenter) {
        if (localData.getRegister("ID_USERCURRENT").equals("PER_1")){
            Call<LikesData> call = apiAdapter.getApiService2().likes_received(localData.getRegister("PER_2"));
            call.enqueue(new Callback<LikesData>() {
                @Override
                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                    if (response.isSuccessful()) {
                        LikesData list = response.body();
                        presenter.getLikesReceivedSuccessful(list.getResults());
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Inténtalo nuevamente";
                        try {
                            response_user = custom_error.returnMessageError(response.errorBody().string());
                        } catch (IOException e) { e.printStackTrace(); }
                        presenter.getLikesError(response_user);
                    }
                }
                @Override
                public void onFailure(Call<LikesData> call, Throwable t) { }
            });
        } else {
            Call<LikesData> call = apiAdapter.getApiService2().likes_received(localData.getRegister("PER_2"));
            call.enqueue(new Callback<LikesData>() {
                @Override
                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                    if (response.isSuccessful()) {
                        LikesData list = response.body();
                        presenter.getLikesReceivedSuccessful(list.getResults());
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Inténtalo nuevamente";
                        try {
                            response_user = custom_error.returnMessageError(response.errorBody().string());
                        } catch (IOException e) { e.printStackTrace(); }
                        presenter.getLikesError(response_user);
                    }
                }
                @Override
                public void onFailure(Call<LikesData> call, Throwable t) { }
            });
        }
    }
}
