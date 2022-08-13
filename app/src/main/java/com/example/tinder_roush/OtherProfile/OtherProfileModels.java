package com.example.tinder_roush.OtherProfile;

import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherProfileModels implements OtherProfileInterfaces.models{

    ApiAdapter apiAdapter;
    LocalData localData;

    public OtherProfileModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }

    @Override
    public void getOtherInformationModel(OtherProfileInterfaces.presenters presenter) {
        if (localData.getRegister("ID_USERCURRENT").equals(localData.getRegister("PERSON2"))){
            Call<HomeResponse> call = apiAdapter.getApiService2().persons_user_photo(localData.getRegister("PERSON1"));
            call.enqueue(new Callback<HomeResponse>() {
                @Override
                public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                    if (response.isSuccessful()) {
                        HomeResponse home_card_list = response.body();
                        presenter.getOtherInformationSuccess(home_card_list.getResults());
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
                        try {
                            response_user = custom_error.returnMessageError(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        presenter.getOtherInformationError(response_user);
                    }
                }
                @Override
                public void onFailure(Call<HomeResponse> call, Throwable t) {
                    Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Call<HomeResponse> call = apiAdapter.getApiService2().persons_user_photo(localData.getRegister("PERSON2"));
            call.enqueue(new Callback<HomeResponse>() {
                @Override
                public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                    if (response.isSuccessful()) {
                        HomeResponse home_card_list = response.body();
                        presenter.getOtherInformationSuccess(home_card_list.getResults());
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
                        try {
                            response_user = custom_error.returnMessageError(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        presenter.getOtherInformationError(response_user);
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
