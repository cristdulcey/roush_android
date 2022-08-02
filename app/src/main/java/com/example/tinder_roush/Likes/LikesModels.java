package com.example.tinder_roush.Likes;

import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.LikesData;
import com.example.tinder_roush.Utils.BaseContext;
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
        Call<LikesData> call = apiAdapter.getApiService2().likes(localData.getRegister("PERSON1"));
        call.enqueue(new Callback<LikesData>() {
            @Override
            public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                if (response.isSuccessful()){
                    LikesData list = response.body();
               //     presenter.getPhotosLikes();
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

    @Override
    public void getPhotosLikeModel(LikesInterfaces.presenters presenter) {
        if (localData.getRegister("ID_USERCURRENT").equals(localData.getRegister("PERSON2"))){
            Call<HomeResponse> call = apiAdapter.getApiService2().likesPhotos(localData.getRegister("PERSON1"));
            call.enqueue(new Callback<HomeResponse>() {
                @Override
                public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                    if (response.isSuccessful()) {
                        //HomeResponse home_card_list = null;
                        assert response.body() != null;
//                        CardPersonItem card= response.body().getResults().get(0);
//                        localData.register(card.getImage(), "IMAGE_LIKE");
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
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
                    Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            Call<HomeResponse> call = apiAdapter.getApiService2().persons_photo(localData.getRegister("PERSON2"));
            call.enqueue(new Callback<HomeResponse>() {
                @Override
                public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                   //     CardPersonItem card= response.body().getResults().;
                 //       localData.register(response.body()., "IMAGE_LIKE");
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
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
                    Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
