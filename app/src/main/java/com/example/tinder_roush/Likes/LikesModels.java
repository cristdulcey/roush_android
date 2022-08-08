package com.example.tinder_roush.Likes;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
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
        Call<LikesData> call = apiAdapter.getApiService2().likes();
        call.enqueue(new Callback<LikesData>() {
            @Override
            public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                if (response.isSuccessful()) {
                    presenter.getLikesPresenter(response.body().getResults());
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
    @Override
    public void getAllLikesReModel(LikesPresenters presenter) {
        Call<LikesData> call = apiAdapter.getApiService2().likesR();
        call.enqueue(new Callback<LikesData>() {
            @Override
            public void onResponse(Call<LikesData> call, Response<LikesData> response) {
                if (response.isSuccessful()) {
                    presenter.getLikesReceivedPresenter(response.body().getResults());
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

//    //likes given
//    @Override
//    public void getLikesModel(LikesInterfaces.presenters presenter) {
//        if (localData.getRegister("ID_USERCURRENT").equals(localData.getRegister("PERSON1"))){
//            Call<LikesData> call = apiAdapter.getApiService2().likes_given(localData.getRegister("PERSON1"));
//            call.enqueue(new Callback<LikesData>() {
//                @Override
//                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
//                    if (response.isSuccessful()) {
//                        LikesData list = response.body();
//                        presenter.getLikesSuccessful(list.getResults());
//                    } else {
//                        CustomErrorResponse custom_error = new CustomErrorResponse();
//                        String response_user = "Inténtalo nuevamente";
//                        try {
//                            response_user = custom_error.returnMessageError(response.errorBody().string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        presenter.getLikesError(response_user);
//                    }
//                }
//                @Override
//                public void onFailure(Call<LikesData> call, Throwable t) {}
//            });
//        }
//        else {
//            Call<LikesData> call = apiAdapter.getApiService2().likes_given(localData.getRegister("PERSON2"));
//            call.enqueue(new Callback<LikesData>() {
//                @Override
//                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
//                    if (response.isSuccessful()) {
//                        LikesData list = response.body();
//                        presenter.getLikesSuccessful(list.getResults());
//                    } else {
//                        CustomErrorResponse custom_error = new CustomErrorResponse();
//                        String response_user = "Inténtalo nuevamente";
//                        try {
//                            response_user = custom_error.returnMessageError(response.errorBody().string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        presenter.getLikesError(response_user);
//                    }
//                }
//                @Override
//                public void onFailure(Call<LikesData> call, Throwable t) { }
//            });
//        }
//    }
//
//    //likes received
//    @Override
//    public void getLikesReceivedModel(LikesInterfaces.presenters presenter) {
//        if (localData.getRegister("ID_USERCURRENT").equals(localData.getRegister("PERSON1"))){
//            Call<LikesData> call = apiAdapter.getApiService2().likes_received(localData.getRegister("PERSON2"));
//            call.enqueue(new Callback<LikesData>() {
//                @Override
//                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
//                    if (response.isSuccessful()) {
//                        LikesData list = response.body();
//                        presenter.getLikesReceivedSuccessful(list.getResults());
//                    } else {
//                        CustomErrorResponse custom_error = new CustomErrorResponse();
//                        String response_user = "Inténtalo nuevamente";
//                        try {
//                            response_user = custom_error.returnMessageError(response.errorBody().string());
//                        } catch (IOException e) { e.printStackTrace(); }
//                        presenter.getLikesError(response_user);
//                    }
//                }
//                @Override
//                public void onFailure(Call<LikesData> call, Throwable t) { }
//            });
//        } else {
//            Call<LikesData> call = apiAdapter.getApiService2().likes_received(localData.getRegister("PERSON1"));
//            call.enqueue(new Callback<LikesData>() {
//                @Override
//                public void onResponse(Call<LikesData> call, Response<LikesData> response) {
//                    if (response.isSuccessful()) {
//                        LikesData list = response.body();
//                        presenter.getLikesReceivedSuccessful(list.getResults());
//                    } else {
//                        CustomErrorResponse custom_error = new CustomErrorResponse();
//                        String response_user = "Inténtalo nuevamente";
//                        try {
//                            response_user = custom_error.returnMessageError(response.errorBody().string());
//                        } catch (IOException e) { e.printStackTrace(); }
//                        presenter.getLikesError(response_user);
//                    }
//                }
//                @Override
//                public void onFailure(Call<LikesData> call, Throwable t) { }
//            });
//        }
//    }
}
