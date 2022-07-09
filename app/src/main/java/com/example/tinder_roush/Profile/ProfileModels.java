package com.example.tinder_roush.Profile;

import android.util.Log;
import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.CustomErrorResponse;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileModels implements ProfileInterfaces.models{

    ApiAdapter apiAdapter;
    LocalData localData;
    public ProfileModels() {
        this.apiAdapter = new ApiAdapter();
        this.localData = new LocalData();
    }

    @Override
    public void ProfileModel(ProfileInterfaces.presenters presenter) {
        Call<ProfileData> call = apiAdapter.getApiService2().current_user();
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    presenter.ProfileSuccessful(response.body());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.ProfileError(response_user);
                }
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ProfileEditModel(ProfileInterfaces.presenters presenter) {
        Call<ProfileData> call = apiAdapter.getApiService2().current_user();
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    presenter.ProfileEditSuccessful(response.body());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.ProfileError(response_user);
                }
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ProfilePhotoModel(ProfileInterfaces.presenters presenter) {
        Call<CardPersonItem> call = apiAdapter.getApiService2().persons_photo_id(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<CardPersonItem>() {
            @Override
            public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                if (response.isSuccessful()){
                    presenter.ProfileGetPhotoSuccessful(response.body());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.ProfileError(response_user);
                }
            }

            @Override
            public void onFailure(Call<CardPersonItem> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ProfileShowPhotoModel(ProfileInterfaces.presenters presenter) {
        Call<CardPersonItem> call = apiAdapter.getApiService2().persons_photo_id(localData.getRegister("Id_Image_1"));
        call.enqueue(new Callback<CardPersonItem>() {
            @Override
            public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                if (response.isSuccessful()){
                    presenter.ProfileShowPhotoSuccessful(response.body());
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.ProfileError(response_user);
                }
            }

            @Override
            public void onFailure(Call<CardPersonItem> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void changeDataModel(ProfileInterfaces.presenters presenter, ProfileData data) {
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("first_name", null, RequestBody.create(MediaType.parse("text/plain"),data.getFirst_name()));
        request.addFormDataPart("last_name", null, RequestBody.create(MediaType.parse("text/plain"),data.getLast_name()));
        request.addFormDataPart("email", null, RequestBody.create(MediaType.parse("text/plain"),data.getEmail()));
        request.addFormDataPart("date_birth", null, RequestBody.create(MediaType.parse("text/plain"),data.getDate_birth()));
        request.addFormDataPart("about", null, RequestBody.create(MediaType.parse("text/plain"),data.getAbout()));
        request.addFormDataPart("job", null, RequestBody.create(MediaType.parse("text/plain"),data.getJob()));

        MultipartBody body=request.build();

        Call<ProfileData> call = apiAdapter.getApiService2().changeProfile(localData.getRegister("ID_USERCURRENT"), body);
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    presenter.changeDataSuccessful();
                }else {
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Intentalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.changeDataError(response_user);
                }
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {

            }
        });
    }
}
