package com.example.sampledemoapp.retrofit;

import com.example.sampledemoapp.models.HomePageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("Home")
    Call<HomePageResponse> getHomePage();

}
