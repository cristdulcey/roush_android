package com.example.tinder_roush.Profile;

import android.util.Log;
import android.widget.Toast;

import com.example.tinder_roush.Api.ApiAdapter;
import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.ChangePassword;
import com.example.tinder_roush.Objects.CityResponse;
import com.example.tinder_roush.Objects.HomeResponse;
import com.example.tinder_roush.Objects.ProfileData;
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
    public void citiesModels(ProfileInterfaces.presenters presenter) {
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
                    presenter.ProfileError(response_user);
                }
            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                Log.e("error ciudades",call.toString());
            }
        });
    }

    @Override
    public void citiesModels2(ProfileInterfaces.presenters presenter) {
        Call<CityResponse> call = apiAdapter.getApiService().cities();
        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.isSuccessful()){
                    CityResponse cities = response.body();
                    presenter.citiesSuccessfulEdit(cities.getCities());
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
            public void onFailure(Call<CityResponse> call, Throwable t) {
                Log.e("error ciudades",call.toString());
            }
        });
    }

    //DATA USER
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


    // GET INTERESTING USER
    @Override
    public void ProfileInterestModel(ProfileInterfaces.presenters presenter) {
        Call<ProfileData> call = apiAdapter.getApiService2().current_user();
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    presenter.ProfileInterestSuccessful(response.body());
                   // presenter.ProfileEditInterestSuccessful(response.body());
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


    //GET EDIT DATA USER
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
    public void ProfileModelPhotos(ProfileInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().persons_user_photo(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    HomeResponse home_card_list = null;
                    home_card_list = response.body();
                    presenter.ProfileSuccessGetPhotos(home_card_list.getResults());
                 //   presenter.ProfileEditSuccessGetPhotos(home_card_list.getResults());
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


    //GET PROFILE PHOTO USER
    @Override
    public void ProfilePhotoModel(ProfileInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().persons_user_photo(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    int total_photos = response.body().getCount();
                    ArrayList<CardPersonItem> home_card_list = response.body().getResults();
                    for (int i=0; i<=total_photos;i++){
                        if (!home_card_list.get(i).getPrincipal()) {
                            continue;
                        }
                        presenter.ProfilePhotoUserSuccess(home_card_list.get(i));
                        break;
                    }
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


    //GET PROFILE EDIT PHOTO USER
    @Override
    public void ProfileGetEditPhotoModel(ProfileInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().persons_user_photo(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    int total_photos = response.body().getCount();
                    ArrayList<CardPersonItem> home_card_list = response.body().getResults();
                    for (int i=0; i<=total_photos;i++){
                        if (!home_card_list.get(i).getPrincipal()) {
                            continue;
                        }
                        presenter.ProfilePhotoUserEdit(home_card_list.get(i));
                        break;
                    }
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
        Call<CardPersonItem> call = apiAdapter.getApiService2().profile_photo(data.getId(), data.getPrincipal());
        if(data.getPrincipal()) {
            localData.register(data.getId(),"ID_PHOTO");
            call.enqueue(new Callback<CardPersonItem>() {
                @Override
                public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                    if (response.isSuccessful()) {
                        presenter.ProfilePhotoGetSuccess(response.body());
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
                public void onFailure(Call<CardPersonItem> call, Throwable t) {
                    Toast.makeText(BaseContext.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



    //GET PHOTOS AND INTERESTING ON PROFILE EDIT ACTIVITY
    @Override
    public void ProfileEditInterestModel(ProfileInterfaces.presenters presenter) {
        Call<ProfileData> call = apiAdapter.getApiService2().current_user();
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    presenter.ProfileEditInterestSuccessful(response.body());
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
    public void ProfileEditGetPhotosModel(ProfileInterfaces.presenters presenter) {
        Call<HomeResponse> call = apiAdapter.getApiService2().persons_user_photo(localData.getRegister("ID_USERCURRENT"));
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    HomeResponse home_card_list = null;
                    home_card_list = response.body();
                    presenter.ProfileEditSuccessGetPhotos(home_card_list.getResults());
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



    //CHANGE DATA
    public void changeDataModel(ProfileInterfaces.presenters presenter, ProfileData data) {
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("first_name", null, RequestBody.create(MediaType.parse("text/plain"),data.getFirst_name()));
        request.addFormDataPart("last_name", null, RequestBody.create(MediaType.parse("text/plain"),data.getLast_name()));
        request.addFormDataPart("email", null, RequestBody.create(MediaType.parse("text/plain"),data.getEmail()));
        request.addFormDataPart("address", null, RequestBody.create(MediaType.parse("text/plain"),data.getAddress()));
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
    public void changePasswordModel(ProfileInterfaces.presenters presenter, ChangePassword data) {

        Call<ChangePassword> call = apiAdapter.getApiService2().changePassword(data.getCurrent_password(), data.getNew_password());
        call.enqueue(new Callback<ChangePassword>() {
            @Override
            public void onResponse(Call<ChangePassword> call, Response<ChangePassword> response) {
                if (response.isSuccessful()){
                    Toast.makeText(BaseContext.getContext(), "Cambio de contraseña exitoso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BaseContext.getContext(), "Inténtalo nuevamente", Toast.LENGTH_SHORT).show();
                    CustomErrorResponse custom_error = new CustomErrorResponse();
                    String response_user = "Inténtalo nuevamente";
                    try {
                        response_user = custom_error.returnMessageError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.ProfileError(response_user);
                }
            }

            @Override
            public void onFailure(Call<ChangePassword> call, Throwable t) {

            }
        });
    }

    @Override
    public void changePhotoModel(ProfileInterfaces.presenters presenter, CardPersonItem data) {
        File fileImage = new File(localData.getRegister("Image"));
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("image", fileImage.getName(),RequestBody.create(MediaType.parse("image/*"), fileImage));
        request.addFormDataPart("principal",null,RequestBody.create(MediaType.parse("text/plain"), String.valueOf(true)));
        MultipartBody body=request.build();

        Call<CardPersonItem> call = apiAdapter.getApiService2().changePhoto(localData.getRegister("ID_PHOTO"),body);
        try {
            call.enqueue(new Callback<CardPersonItem>() {
                @Override
                public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()){
                        presenter.ProfilePhotoUserPresenter();
                        presenter.ProfilePhotoEditPresenter();
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


    //CHANGE ALL PHOTOS
    @Override
    public void changeGetAllPhotosModel(ProfileInterfaces.presenters presenter, String id) {
        File fileImage = new File(localData.getRegister("Image"));
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("image", fileImage.getName(), RequestBody.create(MediaType.parse("image/*"), fileImage));
        MultipartBody body = request.build();

        Call<CardPersonItem> call = apiAdapter.getApiService2().changePhoto(id, body);
        try {
            call.enqueue(new Callback<CardPersonItem>() {
                @Override
                public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()) {
                        Toast.makeText(BaseContext.getContext(), "Foto actualizada", Toast.LENGTH_SHORT).show();
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

    @Override
    public void postOtherPhotos(ProfileInterfaces.presenters presenter) {
        File fileImage = new File(localData.getRegister("Image"));
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("person", null,RequestBody.create(MediaType.parse("text/plain"), localData.getRegister("ID_USERCURRENT")));
        request.addFormDataPart("image", fileImage.getName(),RequestBody.create(MediaType.parse("image/*"), fileImage));
        request.addFormDataPart("principal",null,RequestBody.create(MediaType.parse("text/plain"), String.valueOf(false)));
        MultipartBody body=request.build();

        Call<CardPersonItem> call = apiAdapter.getApiService2().addAllPhotos(body);
        try {
            call.enqueue(new Callback<CardPersonItem>() {
                @Override
                public void onResponse(Call<CardPersonItem> call, Response<CardPersonItem> response) {
                    Log.d("tag", "onResponse: " + response.message().toString());
                    if (response.isSuccessful()){
                        Toast.makeText(BaseContext.getContext(), "Foto agregada", Toast.LENGTH_SHORT).show();
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


    //CHANGE INTERESTING
    @Override
    public void changeInteresting(ProfileInterfaces.presenters presenter) {
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
        Call<ProfileData> call = apiAdapter.getApiService2().updateInterest(localData.getRegister("ID_USERCURRENT"),body);

        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(BaseContext.getContext(), "Intereses actualizados", Toast.LENGTH_SHORT).show();
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
            }
        });
    }

    @Override
    public void changePreferencesSearch(ProfileInterfaces.presenters presenter) {
        String preferenceGender = localData.getRegister("GENDER_PREFERENCE");
        String withChildren = localData.getRegister("CHILDREN_PREFERENCE");
        String withPets = localData.getRegister("PETS_PREFERENCE");
        String smoker = localData.getRegister("SMOKER_PREFERENCE");
        String distance = localData.getRegister("DISTANCE_RANGE");
        String year_start = localData.getRegister("DATE_START");
        String year_finish = localData.getRegister("DATE_FINISH");

        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("search", null, RequestBody.create(MediaType.parse("text/plain"), preferenceGender));
        request.addFormDataPart("with_children", null, RequestBody.create(MediaType.parse("text/plain"), withChildren));
        request.addFormDataPart("with_pets", null, RequestBody.create(MediaType.parse("text/plain"), withPets));
        request.addFormDataPart("smoker", null, RequestBody.create(MediaType.parse("text/plain"), smoker));
        request.addFormDataPart("distance", null, RequestBody.create(MediaType.parse("text/plain"), distance));
        request.addFormDataPart("year_start", null, RequestBody.create(MediaType.parse("text/plain"), year_start));
        request.addFormDataPart("year_finish", null, RequestBody.create(MediaType.parse("text/plain"), year_finish));
        MultipartBody body = request.build();

        Call<ProfileData> call = apiAdapter.getApiService2().updateInterest(localData.getRegister("ID_USERCURRENT"),body);

        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                 //   Toast.makeText(BaseContext.getContext(), "Datos actualizados", Toast.LENGTH_SHORT).show();
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
            }
        });
    }

    @Override
    public void changeOrientationModel(ProfileInterfaces.presenters presenter) {
        String sexualOrientation = localData.getRegister("SEXUAL_ORIENTATION");
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("sexual_orientation", null, RequestBody.create(MediaType.parse("text/plain"), sexualOrientation));
        MultipartBody body = request.build();

        Call<ProfileData> call = apiAdapter.getApiService2().updateInterest(localData.getRegister("ID_USERCURRENT"),body);

        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(BaseContext.getContext(), "Orientación actualizada", Toast.LENGTH_SHORT).show();
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
            }
        });
    }

    @Override
    public void changeZodiacModel(ProfileInterfaces.presenters presenter) {
        String zodiacSign = localData.getRegister("ZODIAC_SIGN");
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("zodiac_sign", null, RequestBody.create(MediaType.parse("text/plain"), zodiacSign));
        MultipartBody body = request.build();

        Call<ProfileData> call = apiAdapter.getApiService2().updateInterest(localData.getRegister("ID_USERCURRENT"),body);

        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(BaseContext.getContext(), "Signo actualizado", Toast.LENGTH_SHORT).show();
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
            }
        });
    }

    @Override
    public void changeCityModel(ProfileInterfaces.presenters presenter) {
        String city = localData.getRegister("CITY_ID");
        final MultipartBody.Builder request = new MultipartBody.Builder().setType(MultipartBody.FORM);
        request.addFormDataPart("city", null, RequestBody.create(MediaType.parse("text/plain"), city));
        MultipartBody body = request.build();

        Call<ProfileData> call = apiAdapter.getApiService2().updateInterest(localData.getRegister("ID_USERCURRENT"),body);

        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(BaseContext.getContext(), "Ciudad actualizada", Toast.LENGTH_SHORT).show();
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
            }
        });
    }
}
