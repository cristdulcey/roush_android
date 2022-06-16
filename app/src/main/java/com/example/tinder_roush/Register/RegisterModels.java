package com.example.tinder_roush.Register;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterModels implements RegisterInterfaces.models{

    ApiAdapter apiAdapter;
    LocalData localData;

    public RegisterModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }
    public void citiesModels(RegisterInterfaces.presenters presenter) {
        Call<CityResponse> call = apiAdapter.getApiService().cities();
        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.isSuccessful()){
                    CityResponse cities = null;
                    cities = response.body();
                    presenter.citiesSuccessful(cities.getCities());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.citiesError(response_user);
                }
            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void register1Model(Register1Data register1Data, RegisterInterfaces.presenters presenter) {
        localData.register(register1Data.getUsername(),"USERNAME");
        localData.register(register1Data.getFirst_name(),"FIRST_NAME");
        localData.register(register1Data.getLast_name(),"LAST_NAME");
        localData.register(register1Data.getDate_birth(),"DATE_BIRTH");
        localData.register(register1Data.getAddress(),"ADDRESS");
        localData.register(register1Data.getGender(),"GENDER");
        localData.register(register1Data.getEmail(),"EMAIL");
        localData.register(register1Data.getPassword(),"PASSWORD");
        presenter.sendRegister2();
    }

    @Override
    public void register2Model(Register2Data register2Data, RegisterInterfaces.presenters presenter) {
        localData.register(register2Data.getJob(),"JOB");
        localData.register(register2Data.getAbout(),"ABOUT");
        localData.register(register2Data.getSearch(),"SEARCH");
        presenter.sendRegister3();
    }
}
