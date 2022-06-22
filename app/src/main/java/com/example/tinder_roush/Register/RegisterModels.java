package com.example.tinder_roush.Register;

import android.util.Log;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.LoginData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.RegisterResponse;
import com.example.tinder_roush.Objects.TokenResponse;
import com.example.tinder_roush.Objects.UserData;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public void loginModel(RegisterInterfaces.presenters presenter, Register1Data data) {
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
    public void verifyTokenModel(RegisterInterfaces.presenters presenter) {

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
                Log.e("error ciudades",call.toString());
            }
        });
    }

    @Override
    public void register1Model(Register1Data register1Data, RegisterInterfaces.presenters presenter) {

        ArrayList<String> genero = new ArrayList<>();
        genero.add("Hombre");
        genero.add("Mujer");
        genero.add("Trans");
        genero.add("No binario");
        genero.add("Otr@");

        localData.register(register1Data.getUsername(),"USERNAME");
        localData.register(register1Data.getFirst_name(),"FIRST_NAME");
        localData.register(register1Data.getLast_name(),"LAST_NAME");
        localData.register(register1Data.getCity(),"CITY");
        localData.register(register1Data.getDate_birth(),"DATE_BIRTH");
        if(register1Data.getGender()== genero.get(0)){
            localData.register("MAN","GENDER");
        }if(register1Data.getGender()==genero.get(1)){
            localData.register("WOMAN","GENDER");
        }if(register1Data.getGender()==genero.get(2)){
            localData.register("TRANS","GENDER");
        }if(register1Data.getGender()==genero.get(3)){
            localData.register("NOBINARY","GENDER");
        }if(register1Data.getGender()==genero.get(4)){
            localData.register("OTHER","GENDER"); }
        //localData.register(register1Data.getGender(),"GENDER");
        localData.register(register1Data.getEmail(),"EMAIL");
        localData.register(register1Data.getPassword(),"PASSWORD");
        presenter.sendRegister2();
    }

    @Override
    public void register2Model(Register2Data register2Data, RegisterInterfaces.presenters presenter) {

        ArrayList<String> busqueda = new ArrayList<>();
        busqueda.add("Hombres");
        busqueda.add("Mujeres");
        busqueda.add("Ambos");
        busqueda.add("Otr@");

        localData.register(register2Data.getJob(), "JOB");
        localData.register(register2Data.getAbout(), "ABOUT");
        if (register2Data.getSearch() == busqueda.get(0)) {
            localData.register("MAN", "SEARCH");
        }
        if (register2Data.getSearch() == busqueda.get(1)) {
            localData.register("WOMAN", "SEARCH");
        }
        if (register2Data.getSearch() == busqueda.get(2)) {
            localData.register("BOTH", "SEARCH");
        }
        if (register2Data.getSearch() == busqueda.get(3)) {
            localData.register("OTHER", "SEARCH");}

            final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
            request.addFormDataPart("username", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("USERNAME")));
            request.addFormDataPart("first_name", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("FIRST_NAME")));
            request.addFormDataPart("last_name", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("LAST_NAME")));
            request.addFormDataPart("city", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("CITY")));
            request.addFormDataPart("date_birth", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("DATE_BIRTH")));
            request.addFormDataPart("gender", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("GENDER")));
            request.addFormDataPart("email", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("EMAIL")));
            request.addFormDataPart("password", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("PASSWORD")));
            request.addFormDataPart("job", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("JOB")));
            request.addFormDataPart("about", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("ABOUT")));
            request.addFormDataPart("search", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("SEARCH")));


            MultipartBody body = request.build();
            Call<UserData> call = apiAdapter.getApiService().sendInfo(body);
            call.enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, Response<UserData> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()) {
                        UserData user = null;
                        user = response.body();
                        localData.register(user.getId(),"id");
                        Register1Data data = new Register1Data(localData.getRegister("USERNAME"),localData.getRegister("PASSWORD"));
                        presenter.loginPresenter(data);
                    } else {
                        CustomErrorResponse custom_error = new CustomErrorResponse();
                        String response_user = "Intentalo nuevamente";
                        if (response.raw().code() == 400) {
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

    @Override
    public void register3Model(Register3Data register3Data, RegisterInterfaces.presenters presenter) {
        File fileImage = new File(localData.getRegister("Image1"));

        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("person", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("id")));
        request.addFormDataPart("image",fileImage.getName(),RequestBody.create(MediaType.parse("image/*"), fileImage));
        MultipartBody body=request.build();

        Call<Register3Data> call = apiAdapter.getApiService2().addPhoto(body);
        try {
            call.enqueue(new Callback<Register3Data>() {
                @Override
                public void onResponse(Call<Register3Data> call, Response<Register3Data> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()){
                        localData.CreateUser();
                        presenter.onPhotosCheckPoint();
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
                public void onFailure(Call<Register3Data> call, Throwable t) {
                    Log.d("tag", "onResponse: " + t.getMessage());
                }
            });
        } catch (Exception e) {
            Log.d("tag", "onCreate: " + e.getMessage());
        }
    }

    @Override
    public void registerPhotos(RegisterInterfaces.presenters presenter) {

        for (int photo = 2;photo<=6;photo++) {
            File fileImage = new File(localData.getRegister("Image"));
            final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
            request.addFormDataPart("id", null, RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("Id")));
            request.addFormDataPart("image", fileImage.getName(), RequestBody.create(MediaType.parse("image/*"), fileImage));
            MultipartBody body = request.build();

            Call<Register3Data> call = apiAdapter.getApiService2().addPhoto(body);
            try {
                call.enqueue(new Callback<Register3Data>() {
                    @Override
                    public void onResponse(Call<Register3Data> call, Response<Register3Data> response) {
                        Log.d("tag", "onResponse: " + response.message().toString());
                        if (response.isSuccessful()) {
                            localData.CreateUser();
                            presenter.onPhotosCheckPoint();
                        } else {
                            CustomErrorResponse custom_error = new CustomErrorResponse();
                            String response_user = "Intentalo nuevamente";
                            if (response.raw().code() == 400) {
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
                    public void onFailure(Call<Register3Data> call, Throwable t) {
                        Log.d("tag", "onResponse: " + t.getMessage());
                    }
                });
            } catch (Exception e) {
                Log.d("tag", "onCreate: " + e.getMessage());
            }
        }
    }
}

