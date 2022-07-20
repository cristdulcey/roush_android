package com.example.tinder_roush.Register;

import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.LoginData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.Register4Data;
import com.example.tinder_roush.Objects.RegisterResponse;
import com.example.tinder_roush.Objects.TokenResponse;
import com.example.tinder_roush.Objects.UserData;
import com.example.tinder_roush.Utils.BaseContext;
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
        File fileImage2 = new File(localData.getRegister("Image2"));
        File fileImage3 = new File(localData.getRegister("Image3"));
        File fileImage4 = new File(localData.getRegister("Image4"));
        File fileImage5 = new File(localData.getRegister("Image5"));
        File fileImage6 = new File(localData.getRegister("Image6"));

        java.util.List<java.io.File> files = new ArrayList<>();
        files.add(fileImage);
        files.add(fileImage2);
        files.add(fileImage3);
        files.add(fileImage4);
        files.add(fileImage5);
        files.add(fileImage6);

        for (int i = 0; i<files.size();i++){
            if (i==0){
                final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
                request.addFormDataPart("person", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("id")));
                request.addFormDataPart("image", files.get(i).getName(),RequestBody.create(MediaType.parse("image/*"),  files.get(i)));
                request.addFormDataPart("principal",null,RequestBody.create(MediaType.parse("text/plain"), String.valueOf(true)));
                MultipartBody body=request.build();

                Call<Register3Data> call = apiAdapter.getApiService2().addPhoto(body);
                try {
                    call.enqueue(new Callback<Register3Data>() {
                        @Override
                        public void onResponse(Call<Register3Data> call, Response<Register3Data> response) {
                            Log.d("tag", "onResponse: " + response.message().toString());
                            if (response.isSuccessful()){
                                localData.deletePhoto();
                                localData.CreateUser();
                                //presenter.sendRegisterFinal();
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
            }else{
                boolean principal = false;
                final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
                request.addFormDataPart("person", null, RequestBody.create(MediaType.parse("text/plain"),localData.getRegister("id")));
                request.addFormDataPart("image", files.get(i).getName(),RequestBody.create(MediaType.parse("image/*"),  files.get(i)));
                request.addFormDataPart("principal",null,RequestBody.create(MediaType.parse("text/plain"), String.valueOf(false)));

                MultipartBody body=request.build();

                Call<Register3Data> call = apiAdapter.getApiService2().addPhoto(body);
                try {
                    call.enqueue(new Callback<Register3Data>() {
                        @Override
                        public void onResponse(Call<Register3Data> call, Response<Register3Data> response) {
                            Log.d("tag", "onResponse: " + response.message().toString());
                            if (response.isSuccessful()){
                                localData.deletePhoto();
                                localData.CreateUser();
                                //presenter.sendRegisterFinal();
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
        }
        presenter.sendRegisterFinal();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void register4Model(Register4Data register4Data, RegisterInterfaces.presenters presenter) {
        String interest1 = localData.getRegister("PREFERENCE_PHOTO");
        String interest2 = localData.getRegister("PREFERENCE_SHOP");
        String interest3 = localData.getRegister("PREFERENCE_KARAOKE");
        String interest4 = localData.getRegister("PREFERENCE_YOGA");
        String interest5 = localData.getRegister("PREFERENCE_COOK");
        String interest6 = localData.getRegister("PREFERENCE_TENNIS");
        String interest7 = localData.getRegister("PREFERENCE_SPORTS");
        String interest8 = localData.getRegister("PREFERENCE_SWIM");
        String interest9 = localData.getRegister("PREFERENCE_ART");
        String interest10 = localData.getRegister("PREFERENCE_TRAVEL");
        String interest11 = localData.getRegister("PREFERENCE_EXTREME");
        String interest12 = localData.getRegister("PREFERENCE_MUSIC");
        String interest13 = localData.getRegister("PREFERENCE_DRINK");
        String interest14 = localData.getRegister("PREFERENCE_GAMES");

        String interest = interest1+","+interest2+","+interest3+","+interest4+","+interest5+","+interest6+","+
                interest7+","+interest8+","+interest9+","+interest10+","+interest11+","+interest12+","+interest13+","+interest14;

        //remove commas at the beginning and end of the String, and the commas repeated within the same String
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        int n = interest.length();
        for(int i = 0; i < n; i++){
            interest = interest.startsWith(",") ? interest.substring(1) : interest;
            interest = interest.endsWith(",") ? interest.substring(0, interest.length() -1) : interest;
            interest = interest.replaceAll("(.)\\1", "$1");
        }

        request.addFormDataPart("interesting", null, RequestBody.create(MediaType.parse("text/plain"), interest));
        MultipartBody body = request.build();
        Call<Register4Data> call = apiAdapter.getApiService2().addInterest(localData.getRegister("id"),body);

        call.enqueue(new Callback<Register4Data>() {
            @Override
            public void onResponse(Call<Register4Data> call, Response<Register4Data> response) {
                if (response.isSuccessful()){
                        localData.deleteInterest();
                        presenter.registerSuccesful();
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.registerError(response_user);
                }
            }
            @Override
            public void onFailure(Call<Register4Data> call, Throwable t) {
            }
        });
    }
}


