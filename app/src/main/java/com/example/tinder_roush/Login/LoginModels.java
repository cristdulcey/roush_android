package com.example.tinder_roush.Login;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.AccessTokenData;
import com.example.tinder_roush.Objects.LoginData;
import com.example.tinder_roush.Objects.TokenResponse;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModels implements LoginInterfaces.models{

    private ApiAdapter apiAdapter;
    private LocalData localData;

    public LoginModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }

    @Override
    public void loginModel(LoginInterfaces.presenters presenter, LoginData data) {
        Call<TokenResponse> call = apiAdapter.getApiService().login(data.getUsername(),data.getPassword());
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful()){
                    localData.saveToken(response.body().getRefresh(), response.body().getAccess());
                    presenter.loginSuccessful();
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Inténtalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.loginError(response_user);
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void verifyTokenModel(LoginInterfaces.presenters presenter) {
        Call<ResponseBody> call = apiAdapter.getApiService().verifyToken(localData.getAccess());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    presenter.verifyTokenSuccessful();
                }else {
                    if (response.raw().code()==401){
                        refreshTokenModel(presenter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void refreshTokenModel(LoginInterfaces.presenters presenter) {
        Call<AccessTokenData> call = apiAdapter.getApiService().refreshToken(localData.getRefresh());
        call.enqueue(new Callback<AccessTokenData>() {
            @Override
            public void onResponse(Call<AccessTokenData> call, Response<AccessTokenData> response) {
                if (response.isSuccessful()){
                    localData.saveToken(localData.getRefresh(), response.body().getAccess());
                    presenter.verifyTokenSuccessful();
                }else {
                    localData.LogOutApp();
                    presenter.verifyTokenError();
                }
            }

            @Override
            public void onFailure(Call<AccessTokenData> call, Throwable t) {

            }
        });
    }
}
