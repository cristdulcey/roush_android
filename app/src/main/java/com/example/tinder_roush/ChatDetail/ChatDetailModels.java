package com.example.tinder_roush.ChatDetail;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Objects.ChatResponse;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatDetailModels implements ChatDetailInterfaces.models {

    ApiAdapter apiAdapter;
    LocalData localData;

    public ChatDetailModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }

    @Override
    public void getUserCurrentPhoto(ChatDetailInterfaces.presenters presenter) {
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
            public void onFailure(Call<HomeResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void getChatsModel(ChatDetailInterfaces.presenters presenter,String id_chat) {

        Call<ChatData> call = apiAdapter.getApiService2().chats_detail(id_chat);
        call.enqueue(new Callback<ChatData>() {
            @Override
            public void onResponse(Call<ChatData> call, Response<ChatData> response) {
                if (response.isSuccessful()) {
                    ChatData list = response.body();
                    presenter.getChatsSuccessful(list.getChat());
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
            public void onFailure(Call<ChatData> call, Throwable t) {
            }
        });

    }

}
