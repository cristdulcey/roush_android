package com.example.tinder_roush.Register;

import android.util.Log;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Objects.UserData;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
      //  presenter.sendRegister3();

        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("user.username", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("USERNAME")));
        request.addFormDataPart("user.email", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("EMAIL")));
        request.addFormDataPart("user.password", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("PASSWORD")));
        request.addFormDataPart("user.gender", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("GENDER")));
        request.addFormDataPart("user.first_name", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("FIRST_NAME")));
        request.addFormDataPart("user.last_name", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("LAST_NAME")));
        request.addFormDataPart("user.date_birth", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("DATE_BIRTH")));
        request.addFormDataPart("user.address", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("ADDRESS")));
        request.addFormDataPart("user.job", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("JOB")));
        request.addFormDataPart("user.about", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("ABOUT")));
        request.addFormDataPart("user.search", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("SEARCH")));

        MultipartBody body=request.build();
        Call<UserData> call = apiAdapter.getApiService().sendInfo(body);
            call.enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, Response<UserData> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()){
//                        localData.CreateUser();
                        presenter.sendRegister3();
                    }else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
                        if (response.raw().code()==400){
                            Log.d("tag", "apns");
                        }
                        try {
                            response_user = custom_error.returnMessageError(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        presenter.onErrorPresenterRegister(response_user);
                    }
                }
                @Override
                public void onFailure(Call<UserData> call, Throwable t) {
                    Log.d("tag", "onResponse: " + t.getMessage());
                }
            });
    }
}
