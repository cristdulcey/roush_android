package com.example.tinder_roush.Api;

import com.example.tinder_roush.BuildConfig;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.AccessTokenData;
import com.example.tinder_roush.Objects.Payload;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.google.gson.Gson;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static ApiService API_SERVICE;

    public static ApiService getApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = BaseContext.getContext().getString(R.string.server);

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            API_SERVICE = retrofit.create(ApiService.class);
        }

        return API_SERVICE;
    }

    public static ApiService getApiService2() {
        BaseContext baseContext;
        Gson gson1=new Gson();
        LocalData localData=new LocalData();
        baseContext=new BaseContext();
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }

        Base64.Decoder decoder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            decoder = Base64.getDecoder();
        }
        String[] chunks = localData.getAccess().split("\\.");
        String payloadS = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            payloadS = new String(decoder.decode(chunks[1]));
        }
        Payload payload = gson1.fromJson(payloadS, Payload.class);
        if (Long.parseLong(payload.getExp()+"000")< System.currentTimeMillis()){
            Call<AccessTokenData> call = getApiService().refreshToken(localData.getRefresh());
            call.enqueue(new Callback<AccessTokenData>() {
                @Override
                public void onResponse(Call<AccessTokenData> call, Response<AccessTokenData> response) {
                    if (response.isSuccessful()){
                        localData.saveToken(localData.getRefresh(), response.body().getAccess());
                    }else {
                        localData.LogOutApp();
                    }
                }

                @Override
                public void onFailure(Call<AccessTokenData> call, Throwable t) {

                }
            });
        }

        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer "+localData.getAccess()).build();
            return chain.proceed(request);
        });

        OkHttpClient client = builder.build();

        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(BaseContext.getContext().getString(R.string.server)).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(ApiService.class);
    }

}
