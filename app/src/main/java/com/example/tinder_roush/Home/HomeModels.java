package com.example.tinder_roush.Home;

import android.util.Log;
import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModels implements HomeInterfaces.models{

    private ApiAdapter apiAdapter;
    private LocalData localData;

    public HomeModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }

    @Override
    public void HomeModelMatch(HomeInterfaces.presenters presenter) {
        Call<HomeData> call = apiAdapter.getApiService2().persons_match();
        call.enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                if (response.isSuccessful()){
                    localData.register(response.body().getPerson1(),"PERSON1");
                    localData.register(response.body().getPerson2(),"PERSON2");
                    Log.e("ID_PERSON1",localData.getRegister("PERSON1"));
                    Log.e("ID_PERSON2",localData.getRegister("PERSON2"));
                    presenter.HomePresenterGetPhotos(response.body());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.HomeError(response_user);
                }
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void HomeModelPhoto(HomeInterfaces.presenters presenter) {

        Call<HomeResponse> call = apiAdapter.getApiService2().persons_photo();
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()){
                    HomeResponse home_card_list = null;
                    home_card_list = response.body();
                    presenter.HomePresenterSuccess(home_card_list.getImage());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.HomeError(response_user);
                }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
