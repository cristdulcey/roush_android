package com.example.tinder_roush.Home;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    //CITIES
    @Override
    public void citiesModels(HomeInterfaces.presenters presenter) {
        Call<CityResponse> call = apiAdapter.getApiService().cities();
        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.isSuccessful()){
                    CityResponse cities = response.body();
                    presenter.citiesSuccessful(cities.getCities());
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
            public void onFailure(Call<CityResponse> call, Throwable t) {
                Log.e("error ciudades",call.toString());
            }
        });
    }

    //FILTERS
    @Override
    public void HomeFilterUserPreferences(View view, HomeInterfaces.presenters presenter) {
        Call<ProfileData> call = apiAdapter.getApiService2().current_user();
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    presenter.HomeFilterSuccessful(view,response.body());
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
            public void onFailure(Call<ProfileData> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //POST MATCH
    @Override
    public void HomeModelPostMatch(HomeInterfaces.presenters presenter) {
        Call<HomeData> call = apiAdapter.getApiService2().post_persons_match();
        call.enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                if (response.isSuccessful()){
                    String id_match = response.body().getId();
                    localData.register(id_match,"ID_MATCH");
                    ArrayList<HomeData> matchs = new ArrayList<>();
                    matchs.add(response.body());
                    presenter.HomePresenterSuccess(matchs);
                }else {
                    Toast.makeText(BaseContext.getContext(), R.string.no_users, Toast.LENGTH_SHORT).show();
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

    //RESPONSE MATCH
    @Override
    public void HomeModelResponseMatchTrue(HomeInterfaces.presenters presenter) {
        Log.e("user_current",localData.getRegister("ID_USERCURRENT"));
        if (localData.getRegister("ID_USERCURRENT").equals(localData.getRegister("PERSON2"))){
            final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
            request.addFormDataPart("response_person2", null, RequestBody.create(MediaType.parse("text/plain"),"true"));
            MultipartBody body=request.build();

            Call<HomeData> call = apiAdapter.getApiService2().match_response(localData.getRegister("ID_MATCH"),body);
            call.enqueue(new Callback<HomeData>() {
                @Override
                public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                    if (response.isSuccessful()){
                        if ((response.body().isResponse_person1()==true) == ((response.body().isResponse_person2())==true)){
                            presenter.HomeBackResponseMatchSuccess();
                        }else {
                           Log.e("USER_CURRENT_ANSWER",response.toString());
                        }
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
        else {
            final MultipartBody.Builder request2 = new MultipartBody.Builder().setType(MultipartBody.FORM);
            request2.addFormDataPart("response_person1", null, RequestBody.create(MediaType.parse("text/plain"),"true"));
            MultipartBody body2=request2.build();

            Call<HomeData> call = apiAdapter.getApiService2().match_response(localData.getRegister("ID_MATCH"),body2);
            call.enqueue(new Callback<HomeData>() {
                @Override
                public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                    if (response.isSuccessful()){
                        if ((response.body().isResponse_person1()==true) == ((response.body().isResponse_person2())==true)){
                            presenter.HomeBackResponseMatchSuccess();
                        }else {
                            Log.e("USER_CURRENT_ANSWER",response.toString());
                        }
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
    }

    @Override
    public void HomeModelResponseMatchFalse(HomeInterfaces.presenters presenter) {
        if (localData.getRegister("ID_USERCURRENT").equals(localData.getRegister("PERSON2"))){
            final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
            request.addFormDataPart("response_person2", null, RequestBody.create(MediaType.parse("text/plain"),"false"));
            MultipartBody body=request.build();

            Call<HomeData> call = apiAdapter.getApiService2().match_response(localData.getRegister("ID_MATCH"),body);
            call.enqueue(new Callback<HomeData>() {
                @Override
                public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                    if (response.isSuccessful()){
                        Log.e("USER_CURRENT_ANSWER",response.toString());
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
        else {
            final MultipartBody.Builder request2 = new MultipartBody.Builder().setType(MultipartBody.FORM);
            request2.addFormDataPart("response_person1", null, RequestBody.create(MediaType.parse("text/plain"),"false"));
            MultipartBody body2=request2.build();

            Call<HomeData> call = apiAdapter.getApiService2().match_response(localData.getRegister("ID_MATCH"),body2);
            call.enqueue(new Callback<HomeData>() {
                @Override
                public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                    if (response.isSuccessful()){
                        Log.e("USER_CURRENT_ANSWER",response.toString());
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
    }

    @Override
    public void HomeModelPersonCurrent(HomeInterfaces.presenters presenter) {
            Call<ProfileData> call = apiAdapter.getApiService2().current_user();
            call.enqueue(new Callback<ProfileData>() {
                @Override
                public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                    if (response.isSuccessful()){
                        presenter.HomePersonCurrentSuccess(response.body());
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
                public void onFailure(Call<ProfileData> call, Throwable t) {
                    Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    @Override
    public void getUserCurrentPhoto(HomeInterfaces.presenters presenter) {
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
                    presenter.HomeError(response_user);
                }
            }
            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) { }
        });
    }

    }
