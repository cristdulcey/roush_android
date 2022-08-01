package com.example.tinder_roush.RecoveryPassword;

import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoveryPasswordModels implements RecoveryPasswordInterfaces.models{

        private RecoveryPasswordInterfaces.models model;
        private ApiAdapter apiAdapter;

       public RecoveryPasswordModels() {
            this.apiAdapter = new ApiAdapter();
        }

        public void recoverPasswordModel(RecoveryPasswordInterfaces.presenters presenter, String username) {
            Call<ResponseBody> call = apiAdapter.getApiService().recoveryPassword(username);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){
                        presenter.recoverPasswordSuccess(response.message());
                    }else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
                        try {
                            response_user = custom_error.returnMessageError(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        presenter.recoverPasswordError(response_user);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
