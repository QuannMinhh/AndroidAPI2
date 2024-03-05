package com.example.androidapi2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Call<String> getRawJsonData(@Url String url);
}
