package com.example.tinder_roush.Profile;

import android.util.Log;
import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Home.HomeInterfaces;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Objects.Register3Data;
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

    //GET PHOTO USER
    @Override
    public void ProfilePhotoModel(ProfileInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().persons_photo(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    ArrayList<CardPersonItem> home_card_list = response.body().getResults();
                    presenter.ProfilePhotoUserId(home_card_list.get(0));
                } else {
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
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ProfileModelPhotoUser(ProfileInterfaces.presenters presenter, CardPersonItem data) {
        Call<CardPersonItem> call = apiAdapter.getApiService2().profile_photo(data.getId());
        call.enqueue(new Callback<CardPersonItem>() {
            @Override
            public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                if (response.isSuccessful()){
                    presenter.ProfilePhotoUserSuccess(response.body());
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

    //GET EDIT PHOTO USER
    @Override
    public void ProfileGetEditPhotoModel(ProfileInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().persons_photo(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    ArrayList<CardPersonItem> home_card_list = response.body().getResults();
                    presenter.ProfilePhotoUserEdit(home_card_list.get(0));
                } else {
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
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ProfileModelGetEditPhoto(ProfileInterfaces.presenters presenter, CardPersonItem data) {
        localData.register(data.getId(),"ID_PHOTO");
        Call<CardPersonItem> call = apiAdapter.getApiService2().profile_photo(data.getId());
        call.enqueue(new Callback<CardPersonItem>() {
            @Override
            public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                if (response.isSuccessful()){
                    presenter.ProfilePhotoGetSuccess(response.body());
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

    @Override
    public void changePhotoModel(ProfileInterfaces.presenters presenter, CardPersonItem data) {
        File fileImage = new File(localData.getRegister("Image1"));
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("image", fileImage.getName(),RequestBody.create(MediaType.parse("image/*"), fileImage));
        MultipartBody body=request.build();

        Call<CardPersonItem> call = apiAdapter.getApiService2().changePhoto(localData.getRegister("ID_PHOTO"),body);
        try {
            call.enqueue(new Callback<CardPersonItem>() {
                @Override
                public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()){
                        presenter.ProfilePhotoGetSuccess(response.body());
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
                        presenter.ProfileError(response_user);
                    }
                }
                @Override
                public void onFailure(Call<CardPersonItem> call, Throwable t) {
                    Log.d("tag", "onResponse: " + t.getMessage());
                }
            });
        } catch (Exception e) {
            Log.d("tag", "onCreate: " + e.getMessage());
        }
    }
}
